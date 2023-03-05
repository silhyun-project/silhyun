/**
 * 
 */
 console.log('hey');
 //조아요 버튼~토글
 $(document).ready(function() {
   $(".heart-icon").click(function() {
    if ($(this).children().hasClass("bi-heart")) {
      $(this).children().removeClass("bi-heart").addClass("bi-heart-fill");
    } else {
      $(this).children().removeClass("bi-heart-fill").addClass("bi-heart");
    }
  });
  	//비어잇는 하트 누르면 조아요 추가하기
    $(".heart-icon.bi-heart").click(function() {
    var userId = 1; // 사용자 아이디
    var portNum = 1; // 게시글 번호

    var like = {
      userId: userId,
      postId: portNum
    };

    $.ajax({
      url: "/addLike",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(like),
      success: function(data) {
        alert("좋아요가 추가되었습니다.");
      },
      error: function(xhr, textStatus, errorThrown) {
        alert("좋아요 추가에 실패하였습니다.");
      }
    });
  });
  
});