/**
 * reviewUqdateForm.js
 */
 
  
function fileUpAction(){
	document.getElementById('fileBtn').click()
}

 $(function(){
	
	let revNum = $('#revNum').val()
	$.ajax({
		url:"/silhyun/reviewUpdate/"+revNum,
		success: function(res){
			//별점
			makeStar(res.rev.star)
			//내용
			$('#cntn').text(res.rev.cntn)
			//사진
			let photos = res.pho
			$(photos).each(function(i,e){
				console.log(e.thumbnail)

			})
		
		},
		error: function(err){
			console.log(err)
		}
	})
	
	function makeStar(num){
		console.log(num)
		$('#stars input').each(function(i,e){
			if($(e).val() >= num){
				$(e).prop('checked', true)
			}

		})
	}

})