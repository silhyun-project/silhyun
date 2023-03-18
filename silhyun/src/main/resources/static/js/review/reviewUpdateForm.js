/**
 * reviewUqdateForm.js
 */
 
  
function fileUpAction(){
	document.getElementById('fileBtn').click()
}

	var attZone = document.getElementById('attZone');  //붙일곳
    var btnAtt = document.getElementById('fileBtn')  //파일버튼
    //보낼 파일 배열
    var selFiles = new Array();
    //파일 개수 체크 배열
    var fileLenghtCk = new Array();
    //삭제할 배열
    var delFiles = new Array();


    // 이미지와 체크 박스를 감싸고 있는 div 속성
    var divStyle = 'display:inline-block;position:relative;'
                  + 'width:150px;height:120px;margin:5px;z-index:1';
    // 미리보기 이미지 속성
    var imgStyle = 'width:100%;height:100%;z-index:none';
    // 이미지안에 표시되는 체크박스의 속성
    var chkStyle = 'width:30px;height:30px;position:absolute;font-size:10px;'
                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';
                  
	
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
				//이미지 미리보기 div에 붙이기
				attImg(e.thumbnail,e.phoNum)

			})
		
		},
		error: function(err){
			console.log(err)
		}
	})
	
	//기존 파일 미리보기에 append
	function attImg(thum, num){
		fileLenghtCk.push(num); //파일길이 체크배열에 파일 식별키만 넣기
		let img = document.createElement('img')
        img.setAttribute('style', imgStyle)
        img.src = thum;
        
        //div 만들기
        var div = document.createElement('div')
        div.setAttribute('style', divStyle)
        
        //삭제버튼
          var btn = document.createElement('input')
		  btn.setAttribute('type', 'button')
		  btn.setAttribute('value', 'x')
		  btn.setAttribute('delFile', num);
		  btn.setAttribute('style', chkStyle);
		  //삭제버튼 이벤트
		  btn.onclick = function(ev){
		    var ele = ev.srcElement;
		    var delFile = ele.getAttribute('delFile');
		    delFiles.push(delFile)
		    document.getElementById('phoNums').value=delFiles
		    console.log(document.getElementById('phoNums').value)
		    for(var i=0 ;i<fileLenghtCk.length; i++){
		      if(delFile== fileLenghtCk[i]){
		        fileLenghtCk.splice(i, 1);      
		      }
		    }
		    
		    var p = ele.parentNode;
		    attZone.removeChild(p)
		  }
		  div.appendChild(img)
		  div.appendChild(btn)
          attZone.appendChild(div);
	}
	
	function makeStar(num){
		console.log(num)
		$('#stars input').each(function(i,e){
			if($(e).val() >= num){
				$(e).prop('checked', true)
			}

		})
	}
	
	btnAtt.onchange = function(e){

      var files = e.target.files;
      var fileArr = Array.prototype.slice.call(files)
		
      for(f of fileArr){
        imageLoader(f);
      }
      let totalLength = fileLenghtCk.length + selFiles.length
      if(totalLength > 6){   //이게 제대로 되나???
      
		alert("6장 이하의 파일만 업로드 됩니다.")
		
	}
	  let lenght = 6- fileLenghtCk.length
	  selFiles.splice(lenght)

    }  
    
    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
    imageLoader = function(file){
      selFiles.push(file);
      let totalLength = fileLenghtCk.length + selFiles.length
      console.log(totalLength)
      if(totalLength < 7){
	      var reader = new FileReader();
	      reader.onload = function(ee){
	        let img = document.createElement('img')
	        img.setAttribute('style', imgStyle)
	        img.src = ee.target.result;
	        attZone.appendChild(makeDiv(img, file));
	      }
	
	      reader.readAsDataURL(file);
		}
			      
		     
		}

	/*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
	makeDiv = function(img, file){
	  var div = document.createElement('div')
	  div.setAttribute('style', divStyle)
	  
	  var btn = document.createElement('input')
	  btn.setAttribute('type', 'button')
	  btn.setAttribute('value', 'x')
	  btn.setAttribute('delFile', file.name);
	  btn.setAttribute('style', chkStyle);
	  btn.onclick = function(ev){
	    var ele = ev.srcElement;
	    var delFile = ele.getAttribute('delFile');
	    for(var i=0 ;i<selFiles.length; i++){
	      if(delFile== selFiles[i].name){
	        selFiles.splice(i, 1);      
	      }
	    }
	    
	    dt = new DataTransfer();
	    for(f in selFiles) {
	      var file = selFiles[f];
	      dt.items.add(file);
	    }
	    btnAtt.files = dt.files;
	    var p = ele.parentNode;
	    attZone.removeChild(p)
	  }
	  div.appendChild(img)
	  div.appendChild(btn)
	  return div
	}

})
//리뷰 수정 컨트롤러 보내기
function updateReview(){
	//배열 폼에 담기
	var formData = new FormData($('#myform')[0])
	for(let i=0; i<selFiles.length; i++){  //멀티파트파일보낼꺼
		formData.append("files", selFiles[i])
		}

		$.ajax({
		url: "/silhyun/update",
		type:"post",
		data: formData,
		contentType: false,
		processData: false, 
		success: function(res){
			console.log(res.revNum)  
			//location.href = "/silhyun/reviewList";
			//ajaxReiew({pageNum:1, amount:5})
			
		},
		error: function(err){
			console.log(err)
		}
		
	})
	
}