/**
 *  reviewList.js
 */
 $(function(){
	let ctgr = "R"
	$('.revNum').each(function(i, e){
		let ctgrNum = $(e).val()
		$.ajax({
			url:"/silhyun/getPhoto",
			type:"post",
			data:{ctgr : ctgr,
			      ctgrNum: ctgrNum},
			success: function(res){
				
				if($(res).length > 0){
				    let slider = $('.slider-wrap[name="'+ctgrNum+'"]')
				    slider.slick('slickRemove',null, null, true)
					$(res).each(function(i,e){
						console.log(e.thumbnail)
						let div = $('<div>').attr('class', 'cont')
						let img = $('<img>').attr('src',e.thumbnail)
						slider.slick('slickAdd',div.append(img));
						
					})

				}
				
			
			},
			error:function(err){
				console.log(err)
			}
		})
	})
	
	
	
    $('.slider-wrap').slick({
      slide: 'div',        //슬라이드 되어야 할 태그
      //infinite : true,     //무한 반복 옵션     
      slidesToShow : 4,        // 한 화면에 보여질 컨텐츠 개수
      slidesToScroll : 1,        //스크롤 한번에 움직일 컨텐츠 개수
      speed : 500,     // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
      arrows : true,         // 옆으로 이동하는 화살표 표시 여부
      vertical : false,        // 세로 방향 슬라이드 옵션
      prevArrow : "<button type='button' class='slick-prev'>Previous</button>",
      nextArrow : "<button type='button' class='slick-next'>Next</button>",
      responsive: [ // 반응형 웹 구현 옵션
        {  
          breakpoint: 960, //화면 사이즈 960px
          settings: {
            slidesToShow: 4
          } 
        },
        { 
          breakpoint: 768, //화면 사이즈 768px
          settings: {    
            slidesToShow: 5
          } 
        }
      ]

    });
    
    
    $(".pagination a").on("click", function(e){
    	e.preventDefault();
     	$("#searchFrm").find("input[name='pageNum']").val($(this).attr("href"));
    	console.log($("#searchFrm").find("input[name='pageNum']").val())
    	
    	
    	//apage($('#searchFrm').seralize()) //form안에있는 name이랑 value값을 들고온다.
    	searchFrm.submit(); //폼태그값을 스트링으로 
    })
    

    
     $('.star-ratings-fill').css('width', starPercent($('#starAvg').text()) + '%')	
     
     $('.star-ratings-fill.sm').each(function(i,e){
    	 $(e).css('width', starPercent($(e).attr("starCnt")) + '%')	
     })
     
     
})
    function starPercent(n){ //매개변수에 별점 넣기
        const score = Number(n) * 20;
          return score  + 1.5;
  		}