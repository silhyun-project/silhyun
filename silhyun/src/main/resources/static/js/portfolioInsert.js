/**
 * portfolioInsert
 */
console.log('호출됏니')
var ptgId = 'user1';


$(function() {
	//default사진 누르면 사진 첨부하는 input박스 클릭
	$('.photo-list-containerN1').click(function() {
		$('#photo').click();
	});
	//사진추가버튼 누르면 사진 첨부하는 input박스 클릭
	$('#add-photo-button').click(function() {
		$('#photo').click();
	});

	//사진첨부하는 어쩌구~~~~시작
	var maxFiles = 10;
	$('#photo').change(function() {
		var fileList = $('#photo')[0].files;
		if (fileList.length > maxFiles) {
			alert(`사진은 ${maxFiles}장까지 업로드 할 수 있습니다.`);
			$('#photo').val('');
			return;
		}
		var firstImage = true;
		for (var i = 0; i < fileList.length; i++) {
			var phoRt = fileList[i];
			var reader = new FileReader();
			reader.onload = function(e) {
				var imgSrc = e.target.result;
				if (firstImage) {
					var imgE = `<div class="swiper-slide">
          <div class="pd-gallery-slide">
            <img src="${imgSrc}" class="img-fluid" alt="${phoRt.name}">
          </div>
        </div>`;
					$(".photo-list-containerN1").empty();
					$(".photo-list-containerN1").append(imgE);
					firstImage = false;
				} else {
					var imgEl = `<div class="swiper-slide photo-list-item">
          <div class="pd-gallery-slide-thumb">
            <img src="${imgSrc}" class="img-fluid" alt="${phoRt.name}">
          </div>
        </div>`;
					$('.photo-list-container').append(imgEl);
				}
			};
			reader.readAsDataURL(phoRt);
		}
	});//사진붙이기 완 사진 지우기 버튼 만들어서 지우는 것도 만들기...=================




	// input창에 태그 리스트를 동적으로 생성
	$('#cntn').on('input', function() {
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
					var textAreaPos = $('#cntn').position();
					var textAreaHeight = $('#cntn').height();
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
		var inputText = $('#cntn').val();
		var inputIndex = inputText.lastIndexOf('#');
		if (inputIndex !== -1) {
			var newText = inputText.substring(0, inputIndex + 1) + selectedTag;
			$('#cntn').val(newText);
		}
		$('#tagList').html('');
	});

	$.ajax({
		type: 'GET',
		url: `/silhyun/imsiList/${ptgId}`,
		success: function(result) {
			console.log(result)
			let th = `<tr><th width='200px'>내용</th><th>작성일</th></tr>`
			$('.imsi').append(th)

			for (i = 0; i < result.length; i++) {
				let imsilist = `<tr><td>${result[i].cntn}</td> 
					<td>${result[i].portDate}</td></tr>`
				$('.imsi').append(imsilist)
			}
		}
	})
	
	
	$('.btn.btn-outline-dark.me-3.imsiList').click(function() {
		$('.imsi').toggle();
	})







	//포트폴리오 등록하기 버튼
	$('.btn.btn-dark.me-3.submit').click(function(e) {
		e.preventDefault();


		var upSta = 'Y';
		//사진
		//태그
		//파일 붙이기.
		var formData = new FormData();

		var files = $("#photo").get(0).files;
		for (var i = 0; i < files.length; i++) {
			formData.append("files", files[i]);
		}
		var cntn = $('textarea[name="cntn"]').val();

		formData.append('ptgId', ptgId);
		formData.append('cntn', cntn);
		formData.append('upSta', upSta);



		$.ajax({
			url: "/silhyun/tagList",
			type: "GET",
			success: function(response) {

				var selectTag = cntn.match(/#[^\s#]*/g).map(tag => ({ tagCntn: tag.slice(1) }));
				var vsTags = selectTag
					.map(item => item.tagCntn)
					.filter(tag => !response.map(item => item.tagCntn).includes(tag));
				var tagCntns = vsTags.map(tag => ({ tagCntn: tag }));


				console.log(selectTag);
				console.log(tagCntns)


				formData.append('tagCntn', JSON.stringify(tagCntns));
				$.ajax({
					type: "POST",
					url: "/silhyun/addPortfolio",
					data: formData,
					contentType: false,
					processData: false,
					success: function() {
						console.log("Portfolio 등록완료");
						location.href = `/silhyun/portfolio/${ptgId}`;

					},
					error: function(xhr, status, error) {
						console.log("Error :" + error);
					}
				});
				alert('포트폴리오가 등록되었습니다.');
			}
		});
	});


	//임시저장 버튼
	$('.btn.btn-outline-dark.me-3.imsiSave').click(function(e) {
		e.preventDefault();
		var upSta = 'N';
		//사진
		//태그
		//파일 붙이기.
		var formData = new FormData();

		var files = $("#photo").get(0).files;
		for (var i = 0; i < files.length; i++) {
			formData.append("files", files[i]);
		}
		var cntn = $('textarea[name="cntn"]').val();

		formData.append('ptgId', ptgId);
		formData.append('cntn', cntn);
		formData.append('upSta', upSta);



		$.ajax({
			url: "/silhyun/tagList",
			type: "GET",
			success: function(response) {

				var selectTag = cntn.match(/#[^\s#]*/g).map(tag => ({ tagCntn: tag.slice(1) }));
				var vsTags = selectTag
					.map(item => item.tagCntn)
					.filter(tag => !response.map(item => item.tagCntn).includes(tag));
				var tagCntns = vsTags.map(tag => ({ tagCntn: tag }));


				console.log(selectTag);
				console.log(tagCntns)


				formData.append('tagCntn', JSON.stringify(tagCntns));
				$.ajax({
					type: "POST",
					url: "/silhyun/addPortfolio",
					data: formData,
					contentType: false,
					processData: false,
					success: function() {
						console.log("Portfolio 임시저장 완료");

					},
					error: function(xhr, status, error) {
						console.log("Error :" + error);
					}
				});
				alert('포트폴리오가 등록되었습니다.');
			}
		});
	});




});