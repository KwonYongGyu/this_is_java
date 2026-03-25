class NintendoGame {
  #gameList = [
//    {id:1, name:"마리오 골프", genre:"S", grade:"ALL", price:20000, imgUrl:"https://pimg.mk.co.kr/news/cms/202504/06/news-p.v1.20250404.ad221f845db2489a86c2ff50f32c53fa_P1.png"},
//    {id:2, name:"젤다의 전설", genre:"R", grade:"ALL", price:30000, imgUrl:"https://store.nintendo.co.kr/media/catalog/product/cache/3be328691086628caca32d01ffcc430a/f/i/file.jpg"},
  ];
// 2. 서버에서 DB 데이터를 가져오는 함수 추가
  loadData() {
    $.ajax({
      url: "/api/get-list", // 우리가 만든 컨트롤러 주소
      type: "GET",
      dataType: "json"
    })
    .done((data) => {
      console.log("DB 데이터 로드 성공:", data);
      this.#gameList = data; // 가져온 데이터를 메모리에 저장
      this.printList();      // 화면에 출력
    })
    .fail((error) => {
      console.error("데이터 로드 실패:", error);
    });
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
  // jquery 실행
  let nint = new NintendoGame();
  nint.loadData();
//  nint.printList();

  $("#btnAdd").click((e) => {
    nint.addGame();
  });

  $(document).on("click", "#btnUpt", (e) => {
    nint.updateGame();
  });

  $(document).on("click", "#btnDel", (e) => {
    nint.deleteGame();
  });

  $(document).on("click", ".listDataRow", (e) => {
    nint.printOneGame(e);
  });
});