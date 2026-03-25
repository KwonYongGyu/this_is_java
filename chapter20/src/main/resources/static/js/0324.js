class UserInfo {
  // 1. 내부 유저 리스트 관리 (초기값 예시)
  #userList = [
//    {id: 1, name: "권용규", password: "123", age: 25, email: "kyg@mjc.ac.kr"}
  ];

  // 서버에서 DB 데이터를 가져오는 함수 추가
  loadData() {
      $.ajax({
        url: "/api/get-list2", // 우리가 만든 컨트롤러 주소
        type: "GET",
        dataType: "json"
      })
      .done((data) => {
        console.log("DB 데이터 로드 성공:", data);
        this.#userList = data; // 가져온 데이터를 메모리에 저장
        this.printList();      // 화면에 출력
      })
      .fail((error) => {
        console.error("데이터 로드 실패:", error);
      });
    }
  // 2. 목록 화면 출력
  printList() {
    $(".listDataBlock").empty();
    this.#userList.forEach((item) => {
      $(".listDataBlock").append(this.printRow(item));
    });
  }

  // 3. 목록의 한 줄(Row) 생성 - HTML 구조에 맞게 수정
  printRow(item) {
    let html = `
<div class="listDataRow" style="cursor:pointer;">
  <div class="listItem">
    <input type="hidden" class="idClass" value="${item.id}"/>
    <div class="itemData text-wrapper">${item.name}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${item.age}세</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${item.email}</div>
  </div>
</div>`;
    return html;
  }

  // 4. 입력창 초기화
  clearInputBox() {
    $("#id").val(0);
    $("#name").val("");
    $("#password").val("");
    $("#age").val(0);
    $("#email").val("");
  }

  // 5. 클릭 시 입력창에 데이터 세팅
  setData2InputBox(user) {
    $("#id").val(user.id);
    $("#name").val(user.name);
    $("#password").val(user.password);
    $("#age").val(user.age);
    $("#email").val(user.email);
  }

  // 6. 데이터 검증 (기존 게임 로직에서 유저 로직으로 변경)
  checkInputData(mode) {
    // 1. 추가 모드인데 ID가 0이 아닌 경우 (잘못된 접근)
    if (mode === "add" && $("#id").val() != 0) {
      alert("신규 추가 시에는 ID가 0이어야 합니다.");
      this.clearInputBox(); // 입력창 초기화 후 리턴
      return false;
    }
    // 2. 수정/삭제 모드인데 대상을 선택 안 한 경우 (ID가 0인 경우)
    if ((mode === "update" || mode === "delete") && $("#id").val() == 0) {
        alert("대상을 먼저 선택해 주세요.");
        return false;
    }

    if ($("#name").val().length < 2) {
      alert("이름은 2자 이상 입력하세요.");
      $("#name").focus();
      return false;
    }
    if ($("#password").val().length < 1) {
      alert("비밀번호를 입력하세요.");
      $("#password").focus();
      return false;
    }
    return true;
  }

  // 7. 유저 추가 버튼 동작
  addUser() {
    if (!this.checkInputData("add")) {
    return;
    }

    // 최대 ID값 구하기 (화면용)
//    let maxId = this.#userList.reduce((result, item) => {
//      return result < item.id ? item.id : result;
//    }, 0) + 1;

    let newUser = {
      id: 0
      , name: $("#name").val()
      , password: $("#password").val()
      , age: parseInt($("#age").val()) || 0
      , email: $("#email").val()
    };

    // 서버 전송 및 리스트 반영
    this.insertData(newUser);
  }

  // 8. 서버 AJAX 통신 (URL: /api/insert-data2)
  insertData(userData) {
      $.ajax({
        url: "/api/insert-data2",
        type: "POST",
        data: JSON.stringify(userData),
        contentType: "application/json; charset=utf-8"
      })
      .done((data) => {
        alert("추가 완료!");
        this.loadData(); // 서버에서 최신 목록 다시 불러오기
        this.clearInputBox();
      })
      .fail((error) => { console.error("추가 실패:", error); });
    }

  // 수정 버튼 동작
  updateUser() {
      if (!this.checkInputData("update")) return;

      let userData = {
        id: $("#id").val() * 1,
        name: $("#name").val(),
        password: $("#password").val(),
        age: parseInt($("#age").val()) || 0,
        email: $("#email").val()
      };
      this.updateData(userData);
    }

  updateData(userData) {
      $.ajax({
        url: "/api/update-data2", // Java 컨트롤러의 @PatchMapping 주소
        type: "PATCH",
        data: JSON.stringify(userData),
        contentType: "application/json; charset=utf-8"
      })
      .done((data) => {
        alert("성공적으로 수정되었습니다.");
        this.loadData(); // 수정 후 리스트 갱신
        this.clearInputBox();
      })
      .fail((error) => { console.error("수정 실패:", error); });
  }

  deleteUser() {
    if (!this.checkInputData("delete")) return;
    alert("구현 X");
  }

  // 10. 목록 클릭 시 데이터 로드
  printOneUser(e) {
    let selectId = $(e.currentTarget).find(".idClass").val() * 1;
    let findUser = this.#userList.find((item) => item.id === selectId);

    if (findUser) {
      this.setData2InputBox(findUser);
    }
  }
}

// 초기화
$(() => {
  let userInfo = new UserInfo();
  // 페이지 로드 시 DB 데이터를 가져오도록 호출
  userInfo.loadData();

  $("#btnAdd").click(() => userInfo.addUser());
  $(document).on("click", "#btnUpt", () => userInfo.updateUser());
  $(document).on("click", "#btnDel", () => userInfo.deleteUser());
  $(document).on("click", ".listDataRow", (e) => userInfo.printOneUser(e));
});