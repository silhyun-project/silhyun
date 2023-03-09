/**
 * portfolioInsert
 */
console.log('호출됏니')
$(function() {
	//default사진 누르면 사진 첨부하는 input박스 클릭
	$('.photo-list-containerN1').click(function() {
		$('#photo-list').click();
	});
	//사진추가버튼 누르면 사진 첨부하는 input박스 클릭
	$('#add-photo-button').click(function() {
		$('#photo-list').click();
	});

	//사진첨부하는 어쩌구~~~~시작
	var maxFiles = 10;

	$('#photo-list').change(function() {
		var fileList = $('#photo-list')[0].files;
		if (fileList.length > maxFiles) {
			alert(`사진은 ${maxFiles}장까지 업로드 할 수 있습니다.`);
			$('#photo-list').val('');
			return;
		}
		var firstImage = true;
		for (var i = 0; i < fileList.length; i++) {
			var file = fileList[i];
			var reader = new FileReader();
			reader.onload = function(e) {
				var imgSrc = e.target.result;
				if (firstImage) {
					var imgE = `<div class="swiper-slide">
          <div class="pd-gallery-slide">
            <img src="${imgSrc}" class="img-fluid" alt="${file.name}">
          </div>
        </div>`;
					$(".photo-list-containerN1").empty();
					$(".photo-list-containerN1").append(imgE);
					firstImage = false;
				} else {
					var imgEl = `<div class="swiper-slide photo-list-item">
          <div class="pd-gallery-slide-thumb">
            <img src="${imgSrc}" class="img-fluid" alt="${file.name}">
          </div>
        </div>`;
					$('.photo-list-container').append(imgEl);
				}
			};
			reader.readAsDataURL(file);
		}
	});//사진붙이기 완 사진 지우기 버튼 만들어서 지우는 것도 만들기...=================




	// input창에 태그 리스트를 동적으로 생성
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
						if (i >= 5) {
							tagList.push('<li id="more">...</li>');
							break;
						}
						tagList.push(`<li>${tags[i]}</li>`);
					}
					$('#tagList').html(tagList.join(''));
					var textAreaPos = $('#text-data').position();
					var textAreaHeight = $('#text-data').height();
					var ulWidth = $('#tagList ul').width();
					$('#tagList').css({
						position: 'absolute',
						top: textAreaPos.top + textAreaHeight + 10 + 'px',
						left: textAreaPos.left + 10 + 'px',
						width: ulWidth + 20 + 'px'
					});
					$('#more').click(function() {
						$(this).remove(); // ... 제거 안되노...
						for (var i = 5; i < tags.length; i++) {
							tagList.push(`<li>${tags[i]}</li>`);
						}
						$('#tagList').html(tagList.join(''));
					});
				}
			});
		} else {
			$('#tagList').html('');
		}
	});

	//클릭하면 자동완성
	$('#tagList').on('click', 'li', function() {
		var selectedTag = $(this).text();
		var inputText = $('#text-data').val();
		var inputIndex = inputText.lastIndexOf('#');
		if (inputIndex !== -1) {
			var newText = inputText.substring(0, inputIndex + 1) + selectedTag;
			$('#text-data').val(newText);
		}
		$('#tagList').html('');
	});

	
	
	//포트폴리오 등록하는 버튼...
	$('#submit-button').click(function() {
		var fileList = $('#photo-list')[0].files;
		if (fileList.length === 0) {
			alert('사진을 첨부해 주세요.');
			return;
		}
		if (fileList.length > maxFiles) {
			alert(`사진은 ${maxFiles}장까지 업로드 할 수 있습니다.`);
			$('#photo-list').val('');
			return;
		}
		// 디비에
		// ...
		alert('사진이 등록되었습니다.');
	});





});