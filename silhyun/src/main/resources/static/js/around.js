/**
 * around.js
 */
console.log('around.js열리나요');
	var loginUserId = 'user2';

//정렬메뉴클릭하면 보이게하기.



$(document).ready(function() {


	$('.dropdown').click(function() {
		$('.toggleMenu').toggle();
	});


	$("div .col-sm-6.col-lg-3").click(function() {	//사진클릭하면 생기는 이벤트
		var portNum = $(this).children('div .portInfo').text(); //포트폴리오 번호 가져오기.
		console.log(portNum);


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
				$("#slidePhoto").empty();//이미있는 사진 지우기
				var modalSlideButton =`	<div class="swiper-arrow-style-01 swiper-next swiper-next-01">
										<i class="bi-chevron-right"></i>
									</div>
									<div class="swiper-arrow-style-01 swiper-prev swiper-prev-01">
										<i class="bi-chevron-left"></i>
									</div>
									<div class="swiper-pagination swiper-pagination-white"></div>`
				for (let i = 0; i < dataModalPhoto.length; i++) {
					const phoRt = dataModalPhoto[i].phoRt;//사진리스트 경로
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
				$("#slidePhoto").append(modalSlideButton);
			});


		//포트폴리오내용 모달~
		$.ajax({
			url: '/silhyun/detailPortfolio/' + portNum,
			dataType: 'json',
		})
			.then(res => {
				console.log(res)
				console.log(res[0].ptgId)//작성자.
				res[0].cntn;//내용		
				var likeCount = res[0].likes;//조아요
				res[0].phoNum;//대표사진 넘버		
				res[0].phoRt;//포트폴리오대표사진경로	
				res[0].portDate;//포트폴리오 쓴 날짜
				//포트폴리오내용붙이기//작가사진은 고치기...


				//작가가쓴포트폴리오 작성했을 때 내용 붙이는 거.
				var modalContentSit = `<div>
												<div class="review-image">
													<img class="img-fluid" src="${res[0].phoRt}"
														title="" alt="작가프로필사진자리~~~~">
												</div>
											</div>
											<div class="col ps-3">
												<span><strong class="comNick">${res[0].ptgId}</strong></span>&nbsp;&nbsp;
											</div>
											<div>
												<p>${res[0].cntn}</p>
												<div>
													<i class="bi bi-heart-fill"></i>&nbsp;
													<span><small class="likeCount">${likeCount}</small></span>
												</div>
											</div>`

				$("div #modalContentSit").empty();
				$("div #modalContentSit").append(modalContentSit);
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

			});//모달 내용쪽에 내용띄아주는 아작스
	});//사진클릭햇을 때 생기는 이벤트


});//윈도우어쩌구