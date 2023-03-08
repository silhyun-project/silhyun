/**
 * portfolio.js
 */
var ptgId = 'user1';
var loginUserId = 'user2';

console.log('호출');

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
				console.log(fieldData[0].cdName);
				//for문 돌려서 분야 태그 별로 다시 만들기===========================

				var ptgProfile = `<div class="ptg-inf">
									<div class="ptg-inf-1">
										<div class="products-brand pb-2">
											<span>사진관~ 없으면 프리렌서${ptgInfo[0].stName}</span>
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
									<a class="gallery-link"> <img
										src="${ptgInfo[0].profile}" class="img-fluid" title=""
										alt="">
									</a>
								</div>
								<div class="products-brand pb-2" id="fieldAppend">
											
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
					var ptgProfile2 = `<span>${fieldData[i].cdName}</span>&nbsp;`
					$('#fieldAppend').append(ptgProfile2);//전문분야
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

//해당작가포트폴리오리스트
$.ajax({
	type: 'GET',
	url: '/silhyun/ptgPortfolioList/' + ptgId,
	success: function(ptgPortList) {


		$('#ptgPortList').empty();//포폴리스트 붙일 곳 깔끔희~~~
		for (i = 0; i < ptgPortList.length; i++) {
			var ptgPort = `<div class="col-6 image-container btn-modal">
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


		//모달관련~
		$(".col-6.image-container.btn-modal").click(function() {	//사진클릭하면 생기는 이벤트
			var portNum = $(this).children('div .portInfo').text(); //포트폴리오 번호 가져오기.

			// ptgPortList 배열에서 portNum 값이 portNum과 일치하는 객체를 찾는다.
			var selectedPortfolio = ptgPortList.find(function(portfolio) {
				return portfolio.portNum === portNum;
			});

			// 해당 객체를 사용하여 원하는 동작을 수행한다.
			console.log(selectedPortfolio);

			//해당 게시글 조아요 대잇나 확인 후 경우에 따른 하트 출력
			$.ajax({
				url: `/silhyun/isLiked/${loginUserId}/${portNum}`,
			}).then(res => {
				//(처음화면)값이 있으면 찬하트
				if (res) {//값이 있으면 //첨에는 찬 하트 출력
					if ($(".heart-icon").children().hasClass("bi-heart")) {
						$(".heart-icon").children().removeClass("bi-heart").addClass("bi-heart-fill");
					}
				} else {//(값이 없으면) //첨에는 빈 하트 출력
					if ($(".heart-icon").children().hasClass("bi-heart-fill")) {
						$(".heart-icon").children().removeClass("bi-heart-fill").addClass("bi-heart");
					}
				}//else끝나는 구간
			});//조아요 대잇나 확인 완


			//모달사진띄우는아작스
			$.ajax({
				url: `/silhyun/detailPortfolioPhoto/${portNum}`,
				dataType: 'json',
			})
				.then(dataModalPhoto => {
					console.log(dataModalPhoto)
					var modalSlideButton = `	<div class="swiper-arrow-style-01 swiper-next swiper-next-01">
										<i class="bi-chevron-right"></i>
									</div>
									<div class="swiper-arrow-style-01 swiper-prev swiper-prev-01">
										<i class="bi-chevron-left"></i>
									</div>
									<div class="swiper-pagination swiper-pagination-white"></div>`
					$("#slidePhoto").empty();//이미있는 사진 지우기
					for (let i = 0; i < dataModalPhoto.length; i++) {
						const phoRt = dataModalPhoto[i].phoRt;//사진리스트 경로
						console.log(phoRt)
						// 슬라이드사진태그 생성
						var modalPhoto = `<div class="swiper-slide">
										<div class="bg-no-repeat bg-cover bg-center"
											style="background-image: url(${phoRt});">
											<div class="container">
												<div
													class="row min-vh-85 align-items-center justify-content-center py-12">

												</div>
											</div>
										</div>
									</div>`
						$("#slidePhoto").append(modalPhoto);//만든사진 붙이기
					}
					$("#slidePhoto").append(modalSlideButton);//사진 다 붙이고 슬라이드 버튼 만들기.
				});





			//작가가쓴포트폴리오 작성했을 때 내용 붙이는 거.
			var modalContentSit = `<div>
												<div class="review-image">
													<img class="img-fluid" src="${selectedPortfolio.phoRt}"
														title="" alt="작가프로필사진자리~~~~">
												</div>
											</div>
											<div class="col ps-3">
												<span><strong class="comNick">${selectedPortfolio.ptgId}</strong></span>&nbsp;&nbsp;
											</div>
											<div>
												<p>${selectedPortfolio.cntn}</p>
												<div>
													<i class="bi bi-heart-fill"></i>&nbsp;
													<span><small class="likeCount">likeCount</small></span>
												</div>
											</div>`

			$("div #modalContentSitP").empty();
			$("div #modalContentSitP").append(modalContentSit);
			//작가가쓴포트폴리오 작성했을 때 내용 붙이는 거.


			//모달 하트눌렀을 때 생기는 이벤트
			$(".heart-icon").click(function() {
				//안찬하트라면 눌럿을 때 insert 넣고 성공하면 찬 하트로 바꾸기. 아니면은 실패 메시지.
				var thisHeart = $(this).children();

				if (thisHeart.hasClass("bi-heart")) {
					//값 넣는 아작스
					$.ajax({
						type: 'POST',
						url: '/silhyun/addLike',
						data: JSON.stringify({ id: LoginUserId, portNum: portNum }),
						contentType: 'application/json',
						success: function(result) {
							thisHeart.removeClass("bi-heart").addClass("bi-heart-fill");//찬하트로바꾸기

							//하트 숫자 바꾸기.
							/*		var likeCountElement = thisHeart.closest('.product-detail').find('.likeCount');
									likeCount = parseInt(likeCountElement.text());
									likeCountElement.text(likeCount + 1);*/
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
						data: JSON.stringify({ id: LoginUserId, portNum: portNum }),
						contentType: 'application/json',
						headers: {
							'X-HTTP-Method-Override': 'DELETE'
						},
						success: function(response) {
							thisHeart.removeClass("bi-heart-fill").addClass("bi-heart");//빈하트로 바꾸기
						},
						error: function(error) {
							console.log(error);
							alert('조아요 삭제 실패~');
						}
					});
				}//else부분
			});//모달 하트눌렀을 때 생기는 이벤트

		});//사진클릭햇을 때 생기는 이벤트
		//모달관련 끝

	},
	error: function(xhr, status, error) {
		// Handle error response from server
		console.log(xhr);
	}
});//해당작가필드

////////////////////모달~~~기능~~
const modal = document.getElementById("modalP")


function modalOn() {
	modal.style.display = "flex"
}
function isModalOn() {
	return modal.style.display === "flex"
}
function modalOff() {
	modal.style.display = "none"
}
$('div .btn-modal').on('click', function() {
	modalOn();
});//사진 클릭하면 모달창띄우기 함

$('div .close-area').on('click', function() {
	modalOff();
});//엑스누르면 모달창 닫기

modal.addEventListener("click", e => {
	const evTarget = e.target
	if (evTarget.classList.contains("modal-overlay")) {
		modalOff()
	}
})
window.addEventListener("keyup", e => {
	if (isModalOn() && e.key === "Escape") {
		modalOff()
	}
})
		////////////////////모달~~~








