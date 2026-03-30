class NintendoGame {
  #gameList = [];
  #currentPage = 1; // 현재 페이지를 저장할 프라이빗 변수 선언
  #recordSize = 2;
  // 현재 페이지를 설정하는 세터(Setter) 메서드 추가
    setCurrentPage(page) {
      this.#currentPage = page;
    }
// 1. 데이터를 가져오는 함수 (검색 조건 포함)
  loadData() {
        const searchData = {
          searchName: $("#searchName").val()
          , searchGenre: $("#searchGenre").val()
          , searchGrade: $("#searchGrade").val()
          , page: this.#currentPage // 현재 페이지 번호 전달
          , recordSize: 2 // 한 페이지에 5개씩
        };

        $.ajax({
          url: "/api/get-list",
          type: "GET",
          data: searchData, // 검색 조건을 쿼리 스트링으로 전달
          dataType: "json"
        })
        .done((res) => { // res는 이제 { list: [], totalCount: 0 } 형태입니다.
            console.log("DB 데이터 로드 성공:", res);

            // 1. 핵심 수정: res 자체가 아니라 res.list를 저장해야 합니다.
            this.#gameList = res.list;

            this.printList();

            // 2. 페이징 버튼을 그리는 함수 호출 (전체 개수 전달)
            this.printPagination(res.totalCount);
          })
          .fail((error) => {
            console.error("데이터 로드 실패:", error);
          });
      }
      // 2. 숫자 페이징 버튼 생성 함수 (중복 제거 및 최신 버전)
      printPagination(totalCount) {
        const totalPage = Math.ceil(totalCount / this.#recordSize);
        const pageArea = $("#pageNumbers");
        pageArea.empty();

        for (let i = 1; i <= totalPage; i++) {
          // 현재 페이지는 빨간색 + 테두리 강조
          const activeStyle = (i === this.#currentPage)
                              ? "style='font-weight:bold; color:red; border: 2px solid red;'"
                              : "";
          const btn = `<button class="btnPage" data-page="${i}" ${activeStyle}>${i}</button>`;
          pageArea.append(btn);
        }

        // 숫자 버튼 클릭 이벤트 (.off()로 중복 등록 방지)
        $(".btnPage").off("click").on("click", (e) => {
          this.#currentPage = $(e.currentTarget).data("page");
          this.loadData();
        });

        // 이전/다음 버튼 활성/비활성화
        $("#btnPrev").prop("disabled", this.#currentPage === 1);
        $("#btnNext").prop("disabled", this.#currentPage >= totalPage || totalPage === 0);

        // 현재 페이지 번호 텍스트 표시 (HTML에 해당 ID가 있을 경우)
        $("#displayCurrentPage").text(this.#currentPage);
      }

        // 페이지 변경 함수
      changePage(direction) {
          if (direction === 'next') {
            // 데이터가 5개 미만이면 다음 페이지가 없을 확률이 높지만,
            // 일단은 페이지 번호를 증가시키고 불러옵니다.
            this.#currentPage++;
          } else if (direction === 'prev' && this.#currentPage > 1) {
            this.#currentPage--;
          }
          this.loadData();
        }

      printList() {
        $(".listDataBlock").empty();
        this.#gameList.forEach((item) => {
          // 배열을 순환하면서 item 을 class="frame-2" 태그 안의 자식 태그로 추가한다.
          $(".listDataBlock").append(this.printRow(item));
        });
      }

  printGenre(genre) {
    switch(genre) {
      case "A":
        return "액션";
      case "S":
        return "스포츠";
      case "R":
        return "RPG";
    }
    return "-";
  }

  printGrade(grade) {
    switch(grade) {
      case "ALL":
        return "전체이용";
      case "18":
        return "18세이상";
      case "13":
        return "13세이상";
    }
    return "-";
  }

  printRow(item) {
    let html = `
<div class="listDataRow">
  <div class="listItem">
    <input type="hidden" class="idClass" value="${item.id}"/>
    <div class="itemData text-wrapper">${this.printGenre(item.genre)}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${this.printGrade(item.grade)}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${item.name}</div>
  </div>
</div>`;
    return html;
  }

  clearInputBox() {
    $("#id").val(0);
    $("#name").val("");
    $("#genre").val("A");
    $("#grade").val("ALL");
    $("#price").val(0);
    $("#imgUrl").val("");
  }

  setData2InputBox(game) {
    // $("#id").val(game.id); 이 값은 화면에 안 보이는 <input id="id" type="hidden" hidden 이 필요하다.
    // $("#name").val(game.name);
    $("#id").val(game.id);
    $("#name").val(game.name);
    $("#genre").val(game.genre);
    $("#grade").val(game.grade);
    $("#price").val(game.price);
    $("#imgUrl").val(game.imgUrl);
    $("#showImage").attr("src", game.imgUrl);
  }

  checkInputData(mode) {
    // 사용자 입력데이터 검증한다.
    // 입력데이터가 올바르면 true 리턴
    // 아니면 false 리턴
    if ( mode === "add" && $("#id").val() != 0 ) {
      alert("ID 값이 유효하지 않습니다.");
      return false;
    } else  if ( mode === "update" || mode === "delete" ) {
      if ( $("#id").val() == 0 ) {
        alert("ID 값이 유효하지 않습니다.");
        return false;
      } else {
        return true;
      }
    }
    if ($("#name").val().length < 2 || $("#name").val().length > 30) {
      alert("이름은 2자~30자까지 입력 가능 합니다.");
      $("#name").focus();
      return false;
    }
    if (
      $("#price").val().length < 1 ||
      $("#price").val() * 1 <= 0 ||
      $("#price").val() * 1 > 999999
    ) {
      alert("가격은 1~999999원 까지 입력 가능 합니다.");
      $("#price").focus();
      return false;
    }
    if ($("#imgUrl").val().indexOf("http") !== 0) {
      alert("그림이미지는 http 로 시작해야 합니다.");
      $("#imgUrl").focus();
      return false;
    }
    return true;
  }

  addGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if ( !this.checkInputData("add") ) {
      return;
    }
//    let maxId = this.#gameList.reduce((result, item) => {
//      return result < item.id ? item.id : result;
//    }, 0) + 1;
    // 새로운 데이터는 id:고유번호 가 필요하다. 그러므로 배열 전체 원소의 id의 최대값 에 +1 한 값을 고유한번호로 가져야한다.
    // 입력데이터는 JS 객체로 만든다. let JS객체 = {id:고유번호, name:$("#name").val(), genre:"S", grade:"ALL", price:금액, imgUrl:"http://..."};
    let newGame = {
      id: 0
      , name: $("#name").val()
      , genre: $("#genre").val()
      , grade: $("#grade").val()
      , price: $("#price").val() * 1
      , imgUrl: $("#imgUrl").val()
    };
    // gameList 배열에 JS객체 를 추가한다. this.#gameList.push(JS객체);
//    this.#gameList.push(newGame);
    this.insertData(newGame);
//    this.clearInputBox();
    // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();
//    this.printList();
  }

  insertData(newGame) {
      // 화살표 함수(=>)를 사용해야 내부에서 this(NintendoGame 클래스)를 인식합니다.
      $.ajax({
          url: "/api/insert-data",
          type: "POST",
          dataType: "json",
          data: JSON.stringify(newGame),
          contentType: "application/json"
      })
      .done((data) => { // (data) => 화살표 함수 사용!
          console.log("서버 저장 성공:", data);

          // 1. JS 메모리 배열에 새 데이터 추가 (서버에서 전체를 다시 가져오기 전까지 임시 방편)
//          this.#gameList.push(newGame);
          this.loadData();  // 추가 후 DB에서 전체 리스트를 다시 읽어옴
          // 2. 입력창 초기화
          this.clearInputBox();
//
//          // 3. 화면 리스트 다시 그리기
//          this.printList();

          alert("성공적으로 추가되었습니다.");
      })
      .fail((error) => {
          console.error("저장 실패:", error);
          alert("저장에 실패했습니다. 콘솔을 확인하세요.");
      });
  }

  updateGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if ( !this.checkInputData("update") ) {
      return;
    }
    // 입력데이터는 JS 객체로 만든다. let JS객체 = {id:고유번호, name:$("#name").val(), genre:"S", grade:"ALL", price:금액, imgUrl:"http://..."};
    // gameList 배열에서 JS객체.id 번호랑 같은 원소를 찾는다. let 찾는객체 = this.#gameList.find(() => {});
    // JS객체를 찾는객체로 바꿔치기 한다.
    // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();\
    let gameData = {
      id: $("#id").val() * 1 // * 1을 붙여서 숫자로 변환
      , name: $("#name").val()
      , genre: $("#genre").val()
      , grade: $("#grade").val()
      , price: $("#price").val() * 1
      , imgUrl: $("#imgUrl").val()
    };
    this.updateData(gameData);
  }

  updateData(gameData) {
      $.ajax({
          url: "/api/update-data",
          type: "PATCH", // 컨트롤러와 동일하게 맞춤
          data: JSON.stringify(gameData),
          contentType: "application/json"
      })
      .done((data) => {
          console.log("업데이트 성공:", data);

          // 1. 로컬 메모리(#gameList) 데이터 갱신
//          let index = this.#gameList.findIndex(item => item.id == gameData.id);
//          if (index !== -1) {
//              this.#gameList[index] = gameData;
//          }
          // 최신 리스트를 새로 받아오기에 기존의 로컬 메모리 데이터 갱신은 없어도 된다.
          // 2. 화면 새로고침 및 입력창 초기화
//          this.printList();
          this.loadData();  // 수정 후 DB에서 전체 리스트르 다시 읽어옴
          this.clearInputBox();
          alert("성공적으로 수정되었습니다.");
      })
      .fail((error) => {
          console.error("업데이트 실패:", error);
      });
  }

  deleteGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if ( !this.checkInputData("delete") ) {
      return;
    }
    // gameList 배열에서 기존의 id 번호랑 같은 원소를 찾는다. let 찾는객체 = this.#gameList.find(() => {});
    // 찾는객체를 gameList 배열에서 삭제한다.
    // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();
  }

  deleteData(id) {
      $.ajax({
        url: "/api/delete-data",
        type: "DELETE",
        dataType: "json",
        data: JSON.stringify({ "id": id }),
        contentType: "application/json"
      })
      .done((data) => { // 화살표 함수로 변경하여 this 유지
        alert("성공적으로 삭제되었습니다.");
        this.clearInputBox();
        this.loadData(); // 삭제 후 목록 다시 불러오기
      })
      .fail((error) => {
        alert("삭제 실패");
        console.error(error);
      });
    }

  printOneGame(e) {
    // 화면의 id 값으로 gameList배열에서 찾는다. let id값 = $("#id").val();, let 찾은원소 = this.#gameList.find(() => {});
    let selectId = $(e.currentTarget).find(".idClass").val() * 1;
    console.log(`selectId = ${selectId}`);
    let findGame = this.#gameList.find((item) => {
      return item.id === selectId;
    });
    if ( findGame == undefined ) {
      return;
    }
    // this.setData2InputBox(찾은원소);
    this.setData2InputBox(findGame);
  }
}

$(() => {
  let nint = new NintendoGame();
  nint.loadData();

  // 검색 버튼 클릭 이벤트 (함수 밖으로 뺌)
  // 검색 시 다시 1페이지 부터
  $("#btnSearch").click(() => {
    nint.setCurrentPage(1);
    nint.loadData();
  });

  // 페이징 버튼 이벤트 등록
  $("#btnPrev").click(() => nint.changePage('prev'));
  $("#btnNext").click(() => nint.changePage('next'));

  $("#btnAdd").click(() => nint.addGame());
  $(document).on("click", "#btnUpt", () => nint.updateGame());
  $(document).on("click", "#btnDel", () => {
    // deleteGame 로직을 보완하여 실제 삭제 호출
    if (nint.checkInputData("delete")) {
        if(confirm("정말 삭제하시겠습니까?")) {
            nint.deleteData($("#id").val() * 1);
        }
    }
  });
  $(document).on("click", ".listDataRow", (e) => nint.printOneGame(e));
});