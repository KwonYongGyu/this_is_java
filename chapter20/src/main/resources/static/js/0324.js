class UserInfo {
  // 1. 내부 유저 리스트 관리 (초기값 예시)
  #userList = [
    {id: 1, name: "권용규", password: "123", age: 25, email: "kyg@mjc.ac.kr"}
  ];

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
    if (mode === "add" && $("#id").val() != 0) {
      alert("신규 추가 시 ID는 0이어야 합니다.");
      return false;
    }
    if (mode === "update" || mode === "delete") {
      if ($("#id").val() == 0) {
        alert("대상을 먼저 선택해 주세요.");
        return false;
      }
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
    if (!this.checkInputData("add")) return;

    // 최대 ID값 구하기 (화면용)
    let maxId = this.#userList.reduce((result, item) => {
      return result < item.id ? item.id : result;
    }, 0) + 1;

    let newUser = {
      id: maxId,
      name: $("#name").val(),
      password: $("#password").val(),
      age: parseInt($("#age").val()), // 숫자로 형변환
      email: $("#email").val()
    };

    // 서버 전송 및 리스트 반영
    this.insertData(newUser);
  }

  // 8. 서버 AJAX 통신 (URL: /api/insert-data2)
  insertData(insertData) {
    const self = this; // 콜백 함수 내에서 클래스 접근용

    $.ajax({
        url: "/api/insert-data2",
        type: "POST",
        dataType: "json", // 서버에서 반환하는 데이터가 있다면 json으로 받음
        data: JSON.stringify(insertData),
        contentType: "application/json; charset=utf-8"
    })
    .done(function(data) {
        console.log("성공:", data);
        alert("데이터가 성공적으로 저장되었습니다.");

        // 화면 리스트 업데이트
        self.#userList.push(insertData);
        self.printList();
        self.clearInputBox();
    })
    .fail(function(xhr) {
        // 서버에서 void를 리턴하면 성공해도 fail로 올 수 있으므로 status 확인
        if(xhr.status === 200) {
            alert("저장 성공!");
            self.#userList.push(insertData);
            self.printList();
            self.clearInputBox();
        } else {
            console.error("실패:", xhr.status);
            alert("서버 전송 중 오류가 발생했습니다.");
        }
    });
  }

  // 9. 수정/삭제 (과제 대비용 구조 유지)
  updateUser() {
    if (!this.checkInputData("update")) return;
    alert("수정 로직을 구현하세요.");
  }

  deleteUser() {
    if (!this.checkInputData("delete")) return;
    alert("삭제 로직을 구현하세요.");
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
  userInfo.printList();

  $("#btnAdd").click(() => userInfo.addUser());
  $(document).on("click", "#btnUpt", () => userInfo.updateUser());
  $(document).on("click", "#btnDel", () => userInfo.deleteUser());
  $(document).on("click", ".listDataRow", (e) => userInfo.printOneUser(e));
});