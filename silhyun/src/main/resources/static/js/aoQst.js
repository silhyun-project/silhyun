/**
 * 
 */


$(document).ready(function () {
    getAoQstList()

    // 새글쓰기 버튼 클릭 시 모달창 보여주기
    $('#new-post-btn').on('click', function () {
        $('#myModal').css('display', 'block');
    });

    $('.close').on('click', function () {
        $('#myModal').css('display', 'none');
    });

    $('#cancel').on('click', function () {
        $('#myModal').css('display', 'none');
    });

    // 모달창 제출 버튼 클릭 시 제출 처리
    $('#send').on('click', function () {
        $('#myModal').css('display', 'none');
    });

});

//문의글 제출버튼 이벤트
$("#send").click(function () { //문의글 등록
    let qstNum = $(".qstNum").val(); //문의글번호
    let ctgr = 'A' //카테고리
    let ctgrNum = 'user1' //카테고리
    let ttl = $("#title").val(); // 제목
    let qstId = 'catLove'; //문의작성자아이디
    let qstCntn = $("#qstCntn").val(); //문의내용
    let rplySta = 'N'; // 답변유무상태
    let secretSta = $("#secChk").val(); //비밀댓글

    if ($("#secChk").is(':checked')) {
        secretSta = 'Y';
    } else {
        secretSta = 'N'; // 비밀 체크여부
    }
    if (ttl == "") {
        alert("제목을 입력해 주세요.")
        $("#ttl").focus();
        return false; // 제목 미입력시 작성 불가
    }

    if (qstCntn == "") {
        alert("내용을 입력해 주세요.")
        $("#qstCntn").focus();
        return false; // 내용 미입력시 작성 불가
    }

    $.ajax({
        url: "/aoQstInsert",
        type: "POST",
        data: JSON.stringify({
            "qstNum": qstNum, // 문의글 번호
            "ctgr": ctgr,
            "ctgrNum": ctgrNum,
            "ttl": ttl, // 제목
            "id": qstId, //작성자아이디
            "cntn": qstCntn,
            "rplySta": rplySta, // 답글여부
            "secretSta": secretSta // 비밀여부
        }),
        contentType: 'application/json',
        success: function (data) {
            $("#comContent").val("")
            getAoQstList();
        },
        error: function () {
            alert('등록실패');
        }
    });
});


// 리스트출력 Ajax
function getAoQstList() {

    let qstArea = $(".qstArea");
    $.ajax({
        url: "/getAoQstList",
        success: function (result) {

            let str = '';
            $(result).each(function (q, aqst) {
                str += '<div class="divTableRow">'
                str += '<div class="divTableHead" id="ttlName" class="ttlName" style="width: 250px; display:inline-block;">'
                if (aqst.secretSta == 'N') { // aqst.id == id || 권한 == admin 추가
                    str += '<a href="javascript:void(0)" class="ttlBtn" >' + aqst.ttl + '</a>'
                    str += '</div>'
                } else {
                    str += '<a href="#" id="ttlBtn">비밀 문의글입니다.</a>'
                }
                str += '<div class="ansBox" style="display: none;">'
                if (aqst.secretSta == 'N') {
                    str += '<p id="qCntn">' + aqst.cntn + '<p>'
                    if (aqst.ansCntn != null) {
                        str += '<div class="div-title-wrap"><hr>'
                        str += '<h5 class="div-title">"Answer"</h5>'
                        str += '<div class="div-sep-wrap">'
                        str += '<div class="div-sep sep-thin"></div>'
                        str += '</div></div>'
                        str += '<div class="media-ans img-resize">'
                        str += '<p id="ansCntn">' + aqst.ansCntn + '</p>'
                        str += '</div>'
                        str += '<input type="hidden" class="qstNum" id="qstNum" value="' + aqst.qstNum + '">'
                        str += '<input type="hidden" class="comNum" id="comNum" value="' + aqst.comNum + '">'
                        //if(aqst.ctgrNum==작가id)
                        str += '<button class="ansModi">수정</button>'
                        str += '<button class="ansDel">삭제</button>'
                        str += '</div>'
                    }
                } else {
                    str += '<p>비밀 문의글입니다.</p>'
                }
                str += '</div>'
                str += '<div class="divTableCell qstId" id="id">' + aqst.id + '</div>'
                str += '<div class="divTableCell qstDate" id="qstDate">' + aqst.qstDate + '</div>'
                str += '<div class="divTableCell rplySta" id="rplySta">' + aqst.rplySta + '</div>'
                str += '<div class="divTableCell qstBtn">'
                if (aqst.id == "catLove") { //aqst.id == id || 권한 admin,작가 으로 수정 
                    str += '<button class="qstModi">수정</button>'
                    str += '<button class="qstDel">삭제</button>'
                    str += '<input type="hidden" class="qstNum" id="qstNum" value="' + aqst.qstNum + '">'
                }
                if (aqst.ctgrNum == "user1") { //카테고리번호 작가로 변경
                    if (aqst.ansCntn == null) {
                        str += '<button class="ansBtn">답변</button>'
                        str += '<input type="hidden" class="qstNum" id="qstNum" value="' + aqst.qstNum + '">'
                    } else {
                        str += '<button class="ansBtn" style="display: none">답변</button>'
                    }
                }
                str += '</div>'



                str += '<input type="hidden" class="ctgrNum" id="ctgrNum" value="' + aqst.ctgrNum + '">'


                str += '</div>'
            })
            qstArea.html(str);
        }
    })
}

//제목 클릭시 내용 나오는 이벤트 
$(".qstArea").on('click', '.ttlBtn', function () {
    var qstContainer = $(this).closest('.divTableRow');
    qstContainer.find('.ansBox').toggle();
})

//문의글 삭제(답변있는경우 답변도 삭제)
$(".qstArea").on('click', '.qstDel', function () {
    console.log($(this).parent().find('input').val());
    let qstNum = $(this).parent().find('input').val();

    $.ajax({
        url: "/aoQstDelete",
        type: "delete",
        data: {
            qstNum
        },
        success: function (data) {
            getAoQstList()
        }
    })
})

//답변 삭제(답변만 삭제)
$(".qstArea").on('click', '.ansDel', function () {
    console.log($(this).parent().parent().find('.comNum').val());
    console.log($(this).closest('.divTableRow').find('.qstNum').val());
    let comNum = $(this).parent().parent().find('.comNum').val();
    let qstNum = $(this).parent().find('.qstNum').val();

    $.ajax({
        url: "/aoAnsDelete",
        type: "delete",
        data: {
            comNum,
            qstNum
        },
        success: function (data) {
            getAoQstList();
        }
    })
});

//문의 답변 클릭 그룹이벤트
$(".qstArea").on('click', '.ansBtn', function () {
    console.log("dddddddddddddddddddddddddddddddddddddddddddd")
    if ($(this).parent().prev().text() == "답변대기") {
        $('.txtArea').remove();

        var ansCancel = $('<button type="reset" id="cancel" class="ansCancelBtn">취소</button>');
        ansCancel.on('click', function () {
            $('.txtArea').remove(); // "답변내용" textarea와 버튼들 숨기기
        });

        $('<div class="txtArea">').append('<label for="answer" class="ansLabel">답변내용 : </label><textarea class="ansZone" id="ansZone" name="ansZone" rows="5" style="width: 400px;"></textarea>')
            .append('<button id="ansSend" class="ansSend">작성</button>')
            .append(ansCancel)
            .appendTo($('#textBox'))

    }
    console.log($(this).parent().find('input').val());
    let qstNo = $(this).parent().find('input').val();

    $('#ansZone').data("qstNo", qstNo);

});


// 문의 답변 ajax
$(".ansArea").on('click', '#ansSend', function () {
    console.log("wwwwwwwwwwwwwwwwwwwwwwwwwwwww")
    let comNum = $("#comNum").val(); //답변번호
    let ctgr = 'A'; //카테고리
    let ctgrNum = $("#ansZone").data("qstNo"); //카테고리넘버(문의번호)
    let id = 'user1'; //답변작성자아이디
    let ansCntn = $("#ansZone").val(); //답변내용
    console.log(ansCntn)

    if (ansCntn == "") {
        alert("내용을 입력해 주세요.")
        $("#ansZone").focus();
        return false; // 내용 미입력시 작성 불가
    }

    $.ajax({
        url: "/aoAnsInsert",
        type: "POST",
        data: JSON.stringify({
            "comNum": comNum,
            "ctgr": ctgr,
            "ctgrNum": ctgrNum,
            "id": id,
            "cntn": ansCntn
        }),
        contentType: 'application/json',
        success: function (data) {
            $("#ansZone, #ansSend,.ansCancelBtn,.ansLabel").remove();
            getAoQstList();
        },
        error: function () {
            alert('등록실패');
        }
    });
});



//문의 수정 클릭 그룹이벤트
$(".qstArea").on('click', '.qstModi', function () {
    console.log("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq")

    $('.qstModiArea').remove();

    var qstModiCancel = $('<button type="reset" id="qstCancelBtn">취소</button>');

    qstModiCancel.on('click', function () {
        $('.qstModiArea').remove(); // "답변내용" textarea와 버튼들 숨기기
    });

    // 수정할 문의의 제목, 내용 가지고옴
    let qstTitle = $(this).parent().parent().find('a').text();
    let qstContent = $(this).parent().parent().find('.ansBox').text();

    $('<div class="qstModiArea">').append('<label for="title" id="modiTitle">제목 : </label><input type="text" class="qstModiTitle" id="qstModiTitle" name="qstModiTitle" style="width: 400px;"> ')
        .append('<label for="answer" id="modiCon">수정내용 : </label><textarea class="qstModiZone" id="qstModiZone" name="qstModiZone" rows="5" style="width: 400px;"></textarea>')
        .append('<button id="qstModiBtn" class="qstModiBtn">수정하기</button>')
        .append(qstModiCancel)
        .appendTo($('#textBox'))

    console.log($(this).parent().find('input').val());
    let qstNo = $(this).parent().find('input').val();

    console.log(qstTitle)
    console.log(qstContent)
    $('#qstModiZone').data("qstNo", qstNo);
    $('#qstModiTitle').val(qstTitle);
    $('#qstModiZone').val(qstContent);

});

// 문의 수정제출 버튼클릭 이벤트
$(".ansArea").on('click', '#qstModiBtn', function () {
    console.log("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
    let modiTtl = $("#qstModiTitle").val();
    let modiCntn = $("#qstModiZone").val();
    let qstNum = $('#qstModiZone').data("qstNo");

    if (modiTtl == "") {
        alert("제목을 입력해 주세요.")
        $("#qstModiTitle").focus();
        return false;
    }

    if (modiCntn == "") {
        alert("내용을 입력해 주세요.")
        $("#qstModiZone").focus();
        return false;
    }

    $.ajax({
        url: "/aoQstUpdate",
        type: "POST",
        data: JSON.stringify({
            "ttl": modiTtl,
            "cntn": modiCntn,
            "qstNum": qstNum
        }),
        contentType: 'application/json',
        success: function (data) {
            $(".qstModiTitle,.qstModiZone, #qstModiBtn, #qstCancelBtn, #modiTitle, #modiCon").remove();
            getAoQstList();
        },
        error: function () {
            alert('등록실패');
        }
    });
})



//답변 수정 클릭 그룹이벤트
$(".qstArea").on('click', '.ansModi', function () {
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")

    $('.ansModiArea').remove();

    var ansModiCancel = $('<button type="reset" id="ansCancelBtn" class="ansCancelBtn">취소</button>');

    ansModiCancel.on('click', function () {
        $('.ansModiArea').remove(); // "답변내용" textarea와 버튼들 숨기기
    });

    // 수정할 답변 내용 가지고옴
    let ansContent = $(this).parent().children().find('p').text();

    $('<div class="ansModiArea">').append('<label for="answer" id="qstLabel">수정내용 : </label><textarea class="ansModiZone" id="ansModiZone" name="ansModiZone" rows="5" style="width: 400px;"></textarea>')
        .append('<button id="ansModiBtn" class="ansModiBtn">수정하기</button>')
        .append(ansModiCancel)
        .appendTo($('#textBox'))


    console.log($(this).parent().find('#comNum').val());
    let comNo = $(this).parent().find('#comNum').val(); //수정해야함 com_num으로

    console.log(ansContent)
    $('#ansModiZone').data("comNum", comNo); //수정해야함 com_num으로
    $('#ansModiZone').val(ansContent);

});

// 답변 수정내용 제출버튼 그룹이벤트
$(".ansArea").on('click', '#ansModiBtn', function () {
    console.log("cccccccccccccccccccccccccccccccccccccccc")
    let modiCntn = $("#ansModiZone").val();
    let ansNo = $('#ansModiZone').data("comNum");

    if (modiCntn == "") {
        alert("내용을 입력해 주세요.")
        $("#ansModiZone").focus();
        return false;
    }

    $.ajax({
        url: "/aoAnsUpdate",
        type: "POST",
        data: JSON.stringify({
            "cntn": modiCntn,
            "comNum": ansNo
        }),
        contentType: 'application/json',
        success: function (data) {
            $("#ansModiZone, #ansModiBtn, #ansCancelBtn, #qstLabel").remove();
            getAoQstList();
        },
        error: function () {
            alert('등록실패');
        }
    });
})