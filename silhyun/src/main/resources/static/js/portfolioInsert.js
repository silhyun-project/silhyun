/**
 * portfolioInsert
 */
console.log('호출됏니')
$(function() {
	$('.photo-list-containerN1').click(function() {
		$('#photo-list').click();
	});
	$('#add-photo-button').click(function() {
		$('#photo-list').click();
	});
	$('#photo-list').change(function() {
		var fileList = $('#photo-list')[0].files;
		var firstImage = true;
		for (var i = 0; i < fileList.length; i++) {
			var file = fileList[i];
			var reader = new FileReader();
			reader.onload = function(e) {
				var imgSrc = e.target.result;
				//첫번째 사진 붙이기
				if (firstImage) {
					var imgE = `<div class="swiper-slide">
								<div class="pd-gallery-slide">
								<img src="${imgSrc}" class="img-fluid" alt="${file.name}">
												</div>
											</div>">`;
					$(".photo-list-containerN1").empty();
					$(".photo-list-containerN1").append(imgE);
					firstImage = false;
				} else {
					var imgEl = `<div class="swiper-slide photo-list-item">
					<div class="pd-gallery-slide-thumb">
						<img src="${imgSrc}" class="img-fluid "
							alt="${file.name}">
					</div>
				</div>`
					$('.photo-list-container').append(imgEl);
				}
			};
			reader.readAsDataURL(file);
		}
	});//사진붙이기 완 사진 지우기 버튼 만들어서 지우는 것도 만들기...=================




	// 제이쿼리를 사용하여 태그 리스트를 동적으로 생성하는 코드
	$('#text-data').on('input', function() {
		var inputText = $(this).val();
		var inputIndex = inputText.lastIndexOf('#');
		if (inputIndex !== -1) {
			var tag = inputText.substring(inputIndex + 1);
			$.ajax({
				type: 'GET',
				url: '/silhyun/searchTags',
				data: { tag: tag },
				success: function(result) {
					var tags = result.tags;
					var tagList = [];
					for (var i = 0; i < tags.length; i++) {
						tagList.push('<li>' + tags[i] + '</li>');
					}
					$('#tagList').html(tagList.join(''));
					var textAreaPos = $('#text-data').position();
					var textAreaHeight = $('#text-data').height();
					var ulWidth = $('#tagList').width();
					$('#tagList').css({
						position: 'absolute',
						top: textAreaPos.top + textAreaHeight + 'px',
						left: textAreaPos.left + 'px',
						width: ulWidth + 'px'
					});
				}
			});
		} else {
			$('#tagList').html('');
		}
	});







});