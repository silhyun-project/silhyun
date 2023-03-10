/**
 * modal
 */
console.log('모오오오달~~~');
$(document).ready(function() {
    //모달메뉴
    $('.menuButton').click(function() {
        $('.menuButtonlist').toggle();
    });

    //첨화면
    var images = $('.modalSlider img');
    images.eq(0).addClass('active');//첫번째사진보이기

    let imgIndex = images.filter('.active').index();//이미지 인덱스 찾기.
    if (imgIndex === 0) {
        $('.modalprev').css("display", "none"); //처음화면이전 버튼 비활성화
    }

    //다음버튼누르기
    $('.modalNext').on('click', function() {
        if (imgIndex === images.length - 1) {
            $('.modalNext').css("display", "none"); // 다음 버튼 비활성화
        } else {
            $('.modalprev').css("display", "block");
        }
        images.eq(imgIndex).removeClass('active');//현재이미지에 active빼기
        imgIndex++;//인덱스 추가.
        if (imgIndex === images.length - 1) {
            $('.modalNext').css("display", "none");
        }
        images.eq(imgIndex).addClass('active');//다음이미지에 active추가
    });

    // 다시 이전 버튼을 클릭하면 다음 버튼을 다시 활성화
    $('.modalprev').on('click', function() {
        if (imgIndex === images.length - 1) {
            $('.modalNext').css("display", "block"); // 다음 버튼 활성화
        }
        images.eq(imgIndex).removeClass('active');//현재이미지에 active빼기
        imgIndex--;//인덱스 추가.
        images.eq(imgIndex).addClass('active');//다음이미지에 active추가
        if (imgIndex === 0) {
            $('.modalprev').css("display", "none"); // 다음 버튼 활성화
        }
    });

});//ready어쩌구임