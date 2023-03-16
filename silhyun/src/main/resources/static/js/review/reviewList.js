/**
 *  reviewList.js
 */
 $(function(){

    $(".pagination a").on("click", function(e){
    	e.preventDefault();
     	$("#searchFrm").find("input[name='pageNum']").val($(this).attr("href"));
    	console.log($("#searchFrm").find("input[name='pageNum']").val())
    	
    	
    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
    	//searchFrm.submit(); //폼태그값을 스트링으로 
    })
    

    
     $('.star-ratings-fill').css('width', starPercent($('#starAvg').text()) + '%')	
     
     $('.star-ratings-fill.sm').each(function(i,e){
    	 $(e).css('width', starPercent($(e).attr("starCnt")) + '%')	
     })
     
     
})
    function starPercent(n){ //매개변수에 별점 넣기
        const score = Number(n) * 20;
         // return score  + 1.5;
          return score;
  		}
  		
  		
    	//인써트 버튼 이벤트
	function reviewInsertForm(){
		console.log($('#ptgId').val())
		$('#ptgId').val()
		$.ajax({
			url: '/silhyun/reviewForm'
		})
	}

    