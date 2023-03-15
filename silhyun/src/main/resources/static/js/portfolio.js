/**
 * portfolio.js
 */
var ptgId = 'user1';
var loginUserId = 'user2';

console.log('호출우우우루');



//포트폴리오 해당 작가 정보(프로필)


$.ajax({
	type: 'GET',
	url: '/silhyun/portfolioptg/' + ptgId,
	success: function(ptgInfo) {
		// Handle successful response from server
		console.log(ptgInfo);

		//해당 작가 필드
		$.ajax({
			type: 'GET',
			url: '/silhyun/ptgField/' + ptgId,
			success: function(fieldData) {
				console.log(fieldData);
				//for문 돌려서 분야 태그 별로 다시 만들기===========================
				var profile = ptgInfo[0].stName == null ? '프리랜서' : 'ptgInfo[0].stName';
				var ptgProfile = `	<div class="ptg-inf">
									<div class="ptg-inf-1">
										<div class="products-brand pb-2">
											<span>${profile}</span>
										</div>
										<div class="products-title mb-2">
											<h4 class="h4">${ptgInfo[0].name}</h4>
										</div>
									</div>
									<div class="rating-star text small pb-4">
										<i class="bi-heart-fill active"></i>
										<p>
											<small>${ptgInfo[0].zzims}</small>
										</p>
									</div>

								</div>

								<!-- 작가프로필 사진 -->
								<div class="mb-3">
									<a class="gallery-link"> <img src="${ptgInfo[0].profile}"
										class="img-fluid" title="" alt="사진~~">
									</a>
								</div>
								<div class="products-brand pb-2"><span id="fieldAppend"></span>전문
								</div>
								<div class="product-description">
									<p>${ptgInfo[0].itr}</p>
								</div>

								<div class="product-detail-actions d-flex flex-wrap pt-3">
									<div class="cart-button mb-3 d-flex">
										<button class="btn btn-dark me-3">리뷰 보기</button>
										<button class="btn btn-dark me-3">예약하러가기</button>
									</div>
								</div>
								<div class="product-info-buttons nav pt-4">
									<a href="${ptgInfo[0].inst}"> <i
										class="bi bi-instagram ms-auto"> </i>instagram
									</a>
								</div>`
				$('#ptgInfo').empty();
				$('#ptgInfo').append(ptgProfile);
				$('#fieldAppend').empty();

				for (i = 0; i < fieldData.length; i++) {

					var separator = i < fieldData.length - 1 ? '/' : '';
					var ptgProfile2 = `<span>${fieldData[i].cdName}</span>&nbsp;`;
					$('#fieldAppend').append(ptgProfile2 + separator);
				}
			},
			error: function(xhr, status, error) {
				// Handle error response from server
				console.log(xhr);
			}
		});//해당작가필드

	},
	error: function(xhr, status, error) {
		// Handle error response from server
		console.log(xhr);
	}
});//해당작가정보
//프로필 완.

$('.cart-button.mb-3.d-flex').on('click', 'button', function() {
	console.log('hey')
	//location.href=`/silhyun/ptgDetail/${ptgId}`
	///pay/reserList/{ptgId}예약
})


var ptgPortList = [];//포트폴리오 리스트중에 하나 봅아오는 거
//해당작가포트폴리오리스트
$.ajax({
	type: 'GET',
	url: '/silhyun/ptgPortfolioList/' + ptgId,
	success: function(ptgPortListData) {
		ptgPortList = ptgPortListData

		$('#ptgPortList').empty();//포폴리스트 붙일 곳 깔끔희~~~
		for (i = 0; i < ptgPortList.length; i++) {
			var ptgPort = `<div class="col-6 image-container modalButton">
								<div class='portInfo' style='display:none'>${ptgPortList[i].portNum}</div>
									<a class="gallery-link" href="#"> <img
										src="${ptgPortList[i].phoRt}" class="img-fluid"
										title="" alt="">
										<div class="overlay">
													<div class="overlayText"><i class="bi bi-heart-fill">&nbsp;</i>${ptgPortList[i].likes}</div>
												</div>
									</a>
								</div>`;
			$('#ptgPortList').append(ptgPort);//포트폴리오 붙이기)
		}//포트폴리오 리스트 붙이기 끝 화면구성 끝~

	}

});//해당작가포트폴리오~

$(document).ready(function() {
	//모달관련~
	$(".col-6.image-container.modalButton").on('click', function() {

		var portNum = $(this).children('.portInfo').text();
		console.log(portNum)


		// 해당 번호 가진 배열 찾기
		var selectedPortfolio = ptgPortList.find(function(findPortfolio) {
			return findPortfolio.portNum === portNum;
		});
		console.log(selectedPortfolio)//호출완

		/////
		//화면 구성한 모달에 경우에 따른 하트 출력
		$.ajax({
			url: `/silhyun/isLiked/${loginUserId}/${portNum}`,
		}).then(heart => {
			//(처음화면)값이 있으면 찬하트
			if (heart) {//값이 있으면 //첨에는 찬 하트 출력
				if ($(".heart-icon").hasClass("bi-heart")) {
					$(".heart-icon").removeClass("bi-heart").addClass("bi-heart-fill");
				}
			} else {//(값이 없으면) //첨에는 빈 하트 출력
				if ($(".heart-icon").hasClass("bi-heart-fill")) {
					$(".heart-icon").removeClass("bi-heart-fill").addClass("bi-heart");
				}
			}//else끝나는 구간
		});//조아요 대잇나 확인 완.
		////////////////////////////기본모달 구성 완료



		//해당 포트폴리오번호에 맞는 사진 리스트 가져와서 넣어주기 (((1)))시작
		$.ajax({
			url: `/silhyun/detailPortfolioPhoto/${portNum}`,
			dataType: 'json',
		})
			.then(dataModalPhoto => {
				console.log(dataModalPhoto)//0
				$(".modalSlider").empty();
				var firstImg = true;
				for (let i = 0; i < dataModalPhoto.length; i++) {
					if (firstImg) {
						var modalPhoto = `<img class='active' src="${dataModalPhoto[i].phoRt}" alt="img${i + 1}">`
						$(".modalSlider").append(modalPhoto);//만든사진 붙이기
						firstImg = false;
					} else {
						var modalPhoto2 = `<img src="${dataModalPhoto[i].phoRt}" alt="img${i + 1}">`
						$(".modalSlider").append(modalPhoto2);//만든사진 붙이기
					}
					var images = $('.modalSlider img');

					let imgIndex = images.filter('.active').index();//이미지 인덱스 찾기.
					if (imgIndex === 0) {
						$('.modalprev').css("display", "none"); //처음화면이전 버튼 비활성화
					}
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
					$('.modalprev').off('click').on('click', function() {
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
				}
			});//해당 포트폴리오번호에 맞는 사진 리스트(((1)))끝
		//다음버튼누르기



		//해당 포트폴리오 번호에 맞는 헤더 붙여주기(((2)))시작	
		var modalheader = `<div class="mTopSectionInfoImg">
									<img src="${selectedPortfolio.profile}" alt="이미지">
									</div>
									<div class="mTopSectionImgMaster">
										<div class="modalMasterId">${selectedPortfolio.ptgId}</div>
										&nbsp;&nbsp; <i class="bi-dot"></i>
										<button>follow</button>
									</div>`
		$(".mTopSectionInfo").empty();
		$(".mTopSectionInfo").append(modalheader); //헤더는 다 붙여줌 화면구성을 하자.
		//해당 포트폴리오 번호에 맞는 헤더 붙여주기(((2)))끝



		//해당 포트폴리오 번호에 맞는 내용 븥여주기(((3)))시작

		//해당 포트폴리오 쓴 내용 붙이는 거.
		var modalContentSit = `<div class="mMiddleInfoImg">
				<img src="${selectedPortfolio.profile}" alt="small-image">
								</div>
								<div class="mMiddleInfoImgMaster">
									<div class="mMiddleMasterId">${selectedPortfolio.ptgId}</div>
									&nbsp;&nbsp;
									<p class="mMiddleMasterCon">${selectedPortfolio.cntn}</p>
								</div>`
		$(".mMiddleInfo").empty();
		$(".mMiddleInfo").append(modalContentSit);
		//작가가쓴포트폴리오 작성했을 때 내용 붙이는 거.


		//댓글

		$(".commentBox").empty();//댓글창청



		commentList(portNum)

		//댓글작성
		$("#send").off('click').on('click', function() {

			let contactMessage = $("#contact-message").val(); //댓글내용
			let dep = $("dep").val(); //깊이(댓글,대댓글) 구분
			let grp = $('#contact-message').data("grp"); //댓글그룹
			let comNum = $("comNum").val();



			if ($("#contact-message").data("dep") == "1") {
				dep = 1;
			}


			if (contactMessage == "") {
				alert("내용을 입력해 주세요.")
				$("#contact-message").focus();
				return false;		// 내용 미입력시 작성 불가
			}

			$.ajax({
				url: "/commentInsert",
				type: "POST",
				data: JSON.stringify(
					{
						"id": loginUserId,

						"ctgrNum": portNum,
						"cntn": contactMessage,
						"dep": dep,
						"grp": grp,
						"comNum": comNum
					}
				),
				contentType: 'application/json',
				success: function(data) {
					$("#contact-message").val("");
					$(".commentBox").empty();
					commentList(portNum)
				},
				error: function() {
					alert('등록실패');
				}
			});
		});

		// 동적으로 생성된 태그에 그룹이벤트 부여
		$(".commentBox").off('click').on('click', '#replyWrite', function(e) {
			console.log('클릭')
			console.log($(this).parent().parent().children('#comId').text())// 그룹번호 히든으로 만들어서 그룹번호가져옴
			console.log($(this).parent().parent().children('#comGrp').val())
			let text = $(this).parent().parent().children('#comId').text();
			let group_number = $(this).parent().parent().children('#comGrp').val();

			$('#contact-message').val('@' + $(this).parent().parent().children('#comId').text())
			$('#contact-message').data("dep", "1")
			$('#contact-message').data("grp", group_number);
			$('#grpNum').val($('#contact-message').data("grp"));

		})

		$('.commentBox').off('click').on('click', '#rereplyWrite', function() {
			console.log('클릭')
			console.log($(this).parent().parent().children('#repId').text())// 그룹번호 히든으로 만들어서 그룹번호가져옴
			console.log($(this).parent().parent().children('#repGrp').val())
			let text = $(this).parent().parent().children('#repId').text();
			let group_number = $(this).parent().parent().children('#repGrp').val();

			$('#contact-message').val('@' + $(this).parent().parent().children('#repId').text())
			$('#contact-message').data("dep", "1")
			$('#contact-message').data("grp", group_number);
			$('#grpNum').val($('#contact-message').data("grp"));
		})


		$(".commentBox").off('click').on('click', '.replyShowBtn', function(e) {
			let parentLi = $(this).closest("li"); // 해당 버튼이 속한 li를 찾음
			let popup = parentLi.find(".popup"); // 해당 li 엘리먼트에서 popup 클래스를 가진 엘리먼트를 찾음
			let replyShowBtn = parentLi.find(".replyShowBtn"); // 해당 li 엘리먼트에서 replyShowBtn 클래스를 가진 버튼 엘리먼트를 찾음
			if (popup.is(":visible")) {
				popup.hide();
				replyShowBtn.text('답글 보기');
			} else {
				popup.show();
				replyShowBtn.text('답글 숨기기');
			}
		});


		$(".commentBox").off('click').on('click', '.comDelBtn', function() {
			console.log('삭제클릭')
			console.log($(this).closest('li').find('.comNum').val());
			console.log($(this).closest('li').find('.comGrp').val());
			let comNum = $(this).closest('li').find('.comNum').val(); //삭제할 댓글 번호
			let grp = $(this).closest('li').find('.comGrp').val(); //삭제할 댓글의 그룹
			let commentZone = $(this).closest('li').find('.commentZone');
			$(".commentBox").empty();
			$.ajax({
				url: "/commentDelete",
				type: "delete",
				data: {
					grp
				}
				,
				success: function(data) {
					commentList(portNum)
				}
			})

		})

		$(".commentBox").off('click').on('click', '.reDelBtn', function() {
			console.log('삭제클릭')
			console.log($(this).closest('li').find('.comNum').val());
			let comNum = $(this).closest('li').find('.comNum').val(); //삭제할 댓글 번호
			let commentZone = $(this).closest('li').find('.replyZone');
			$(".commentBox").empty();
			$.ajax({
				url: "/replyDelete",
				type: "delete",
				data: {
					comNum
				}
				,
				success: function(data) {
					commentList(portNum)
				}
			})
		})






		//해당 포트폴리오 번호에 맞는 내용 븥여주기(((3)))끝

		//해당 포트폴리오 번호에 맞는 푸터 븥여주기(((4)))시작
		var modalBottomInfo = `<div class="modalClickIcons">
								<i class="heart-icon bi-heart"></i><i class="chat-icon bi-chat"></i>
							</div>
							<div class="modalHeartInfo">
								<small>좋아요</small> <strong><span>${selectedPortfolio.likes}</span></strong><small>
									개</small>
							</div>
							<div class="modalInsertDate">${selectedPortfolio.portDate + '작성'}</div>`

		$(".modalBottomInfo").empty();
		$(".modalBottomInfo").append(modalBottomInfo);


		//해당 포트폴리오 번호에 맞는 푸터 븥여주기(((4)))끝





		//모달안에서 기능 ==1==하트 시작

		//모달 하트눌렀을 때 생기는 이벤트
		$(".heart-icon").on('click', function() {
			//안찬하트라면 눌럿을 때 insert 넣고 성공하면 찬 하트로 바꾸기. 아니면은 실패 메시지.
			var thisHeart = $(this);

			if (thisHeart.hasClass("bi-heart")) {
				//값 넣는 아작스
				$.ajax({
					type: 'POST',
					url: '/silhyun/addLike',
					data: JSON.stringify({ id: loginUserId, portNum: portNum }),
					contentType: 'application/json',
					success: function(result) {
						thisHeart.removeClass("bi-heart").addClass("bi-heart-fill");//찬하트로바꾸기

						//하트 숫자 올리기.
						var likeCount = parseInt($('.modalHeartInfo').find('span').text());
						$('.modalHeartInfo').find('span').text(likeCount + 1);
					},
					error: function(xhr, status, error) {
						console.log(error);
						alert('좋아요 실패~');
					}
				});
			} else {
				//값 지우는 아작스
				$.ajax({
					url: '/silhyun/deleteLike',
					type: 'POST',
					data: JSON.stringify({ id: loginUserId, portNum: portNum }),
					contentType: 'application/json',
					headers: {
						'X-HTTP-Method-Override': 'DELETE'
					},
					success: function(response) {
						thisHeart.removeClass("bi-heart-fill").addClass("bi-heart");//빈하트로 바꾸기
						//하트 숫자 올리기.
						var likeCount = parseInt($('.modalHeartInfo').find('span').text());
						$('.modalHeartInfo').find('span').text(likeCount - 1);
					},
					error: function(error) {
						console.log(error);
						alert('조아요 삭제 실패~');
					}
				});
			}//else부분
		});//모달 하트눌렀을 때 생기는 이벤트

		//모달안에서 기능 ==1==하트 끝


	});//사진 클릭했을 때 생기는 이벤트 끝 


	function commentList(portNum) {
		$.ajax({
			url: `/commentList/${portNum}`,
			type: 'get',
		})
			.then(result => {
				console.log(result)



				let str = '';
				$(result).each(function(c, comm) {


					if (comm.dep == 0) {
						//댓글자리
						let comment = `<div class="commentZone">
						    
						     <div class="avatar rounded-circle">
						     	<img src="${comm.profile}" alt="small-image">
						     </div>
						     
						     <div class="commentCon">
						     	<div class="commentInfo">
					                <strong><div class="mt-0 mb-1 commentId" id="comId">${comm.id}</div></strong>&nbsp;&nbsp;
					                <div class="commentCon">${comm.cntn}</div>
									<input type="text" class="comGrp" name="grp" id="comGrp" value="${comm.grp}"  style="display:none;">
									<input type="text" class="comNum" name="comNum" value="${comm.comNum}"  style="display:none;">
						     	</div>
						     	<div class='nav dark-link small'>				              
						                     <div class="mb-2 small">${comm.comDate}<div>   
						                     <a class="ms-3" href="#contact-message" id="replyWrite">답글 달기</a>&nbsp;&nbsp;        
						            		 <span class="comDelBtn">삭제<span> &nbsp;&nbsp;
						                     <span class="replyShowBtn"><i class="bi-dash-lg">답글 더보기</i></span>
						     	</div>
						    	 <ul class="popup ${comm.grp}"></ul>
						    </div>
						</div>`
						$(".mMiddleComment").append(comment);
					} else{
						//덧댓글자리
						let recomment = `<li class="replyZone">
								      <div class="avatar rounded-circle">
						     	<img src="${comm.profile}" alt="small-image">
						     </div>
						     
						     <div class="commentCon">
						     	<div class="commentInfo">
					                <strong><div class="mt-0 mb-1 commentId" id="comId">${comm.id}</div></strong>&nbsp;&nbsp;
					                <div class="commentCon">${comm.cntn}</div>
									  <input type="hidden" class="repGrp" name="grp" id="repGrp" value="${comm.grp}">
									   <input type="hidden" class="comNum" name="comNum" value="${comm.comNum}">
						     	</div>
						     	<div class='nav dark-link small'>				              
						                     <div class="mb-2 small">${comm.comDate}<div>   
						                     <a class="ms-3" href="#contact-message" id="rereplyWrite">답글 달기</a>&nbsp;&nbsp;        
						            		 <span class="reDelBtn">삭제<span> &nbsp;&nbsp;
						     	</div>   	
						    </div>
						</li>`
						$(".mMiddleComment").append(recomment);
					}
				})//for

			})//ajax
	}



	console.log('모오오오달~~~');


	const modal = $(".modalBlacklayer");


	$('.modalButton').on('click', function() {
		modal.css("display", "block");
	});





	function isModalOn() {
		return modal.css("display") === "block";
	}

	function modalOff() {//모달끄는거
		modal.css("display", "none");
		imgIndex = 0;
	}

	$('.modalCloseButton').on('click', function() {
		modalOff();
	});

	modal.on("click", function(e) {
		const evTarget = e.target;
		if ($(evTarget).hasClass(".modalBlacklayer")) {
			modalOff();
		}
	});

	$(window).on("keyup", function(e) {
		if (isModalOn() && e.key === "Escape") {
			modalOff();
		}
	});

	////////////////////모달실행~~~

	//모달메뉴
	$('.menuButton').click(function() {
		$('.menuButtonlist').toggle();
	});



})//레디










