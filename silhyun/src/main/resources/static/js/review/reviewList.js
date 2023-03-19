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
    
    $('#sort').on('change', function(){
    	
    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
})

$('#phosort').on('click', function(){

    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
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
	function reviewInsertForm(id){
		//리뷰 작성버튼 체크 ===> 프로미스, then 써보기
    	let ctgrNum = $('#ptgId').val()
    	$.ajax({
			url: '/insertChek',
			data: {ptgId : ctgrNum,
			       id : id},
			success: function(res){
				console.log(res)
			}
		})
    	
		$.ajax({
			url: '/reviewform',
			data: {ctgrNum: ctgrNum,
				   ctgr : 'A'},
		    success: function(res){
		    	$('#reviews').replaceWith(res)
		    }, 
		    error: function(err){
		    	console.log(err)
		    }
			
		})
	}
    
   
	//수정버튼 이벤트 
	function upFrom(num){
		$.ajax({
			url: '/reviewUpform',
			data: {revNum: num},
		    success: function(res){
		    	$('#reviews').replaceWith(res)
		    }, 
		    error: function(err){
		    	console.log(err)
		    }
			
		})
	}
	
	//삭제버튼 이벤트
	function delReview(num){
		console.log(num)
		$.ajax({
			url:'/reviewDel',
			data:{revNum: num},
		     success: function(res){
		    	console.log(res)
		    	ajaxReiew({pageNum:1, amount:5, sort: 'n'}) 
		    }, 
		    error: function(err){
		    	console.log(err)
		    }
		})
	}

	