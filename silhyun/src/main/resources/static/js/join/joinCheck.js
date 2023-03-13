/**
 * joinCheck.js
 */
 $(function(){
	//체크박스 처리
	//전체 체크 클릭
	$('#chkAll').on('click', function(e){
		let ckOk = $(e.target).is(":checked")
		if(ckOk){
			$('.chk').attr("checked", true)
			$('#agree').val('true')
		}else{
			$('.chk').attr("checked", false)
			$('#agree').val('false')
		}
	})
	
	$('.chk').on('click', function(){
	   console.log($('input[class="chk"]:checked').length)
	   //체크개별항목 체크 클릭
	   if($('input[class="chk"]:checked').length >= 4){
			$('#chkAll').attr("checked", true)
			$('#agree').val('true')
		}else{
			$('#chkAll').attr("checked", false)
			$('#agree').val('false')
		}
		//필수체크항목
		let chk1 = $('#chk1').is(":checked")
		let chk2 = $('#chk2').is(":checked")
		if(chk1 && chk2){
			$('#agree').val('true')
			console.log($('#agree').val())
		}else{
			$('#agree').val('false')
			console.log($('#agree').val())
		}
	})
	
	//아이디 체크
	$('#id').blur(function(){
		var id = $('#id').val()
		if(id == ""){
			$('#idMsg').text("아이디를 입력해주세요.")
			           .css("color", "red")
			$('#idCk').val("false")
		}else{
			$.ajax({
				url:"/silhyun/idCk?id="+ id,
				type: "post",
				success : function(res){
					console.log(res)
					if(res){
						$('#idMsg').text("사용가능한 아이디입니다.")
			           				.css("color", "green")
			           	$('#idCk').val("true")
					}else{
						$('#idMsg').text("중복된 아이디입니다..")
			           				.css("color", "red")
			           	$('#idCk').val("false")						
					}
				},
				error : function(err){
					console.log(err)
				}
			})
		}
	})
	
	
	//비번길이+ 입력 체크
	$('#pwd').blur(function(){
		let pwd = $('#pwd').val()
		if(pwd == ""){
			$('#pwdLengtMsg').text('비밀번호를 입력해 주세요')
			                 .css("color", "red")
	        $('#pwLength').val("false")
		}else if(pwd.length < 8 || pwd.length > 15){
			$('#pwdLengtMsg').text('비밀번호를 8자 ~ 15자 사이로 설정해주세요')
                 .css("color", "red")
	        $('#pwLength').val("false")
		}else{
			$('#pwdLengtMsg').text('사용가능한 비밀번호 입니다.')
                 .css("color", "green")
	        $('#pwLength').val("true")			
		}
	})
	
	//비번 확인 체크
	$('#pwdck').blur(function(){
		if($('#pwdck').val() == $('#pwd').val()){
			$('#pwdMgs').text('비밀번호 확인란을 입력해 주세요.')
                 .css("color", "red")
	        $('#pwCk').val("false")			
		}else if($('#pwdck').val() == ""){
			$('#pwdMgs').text('비밀번호가 일치합니다.')
                 .css("color", "green")
	        $('#pwCk').val("true")					
		}else{
			$('#pwdMgs').text('비밀번호가 일치하지 않습니다.')
                 .css("color", "red")
	        $('#pwCk').val("false")				
		}
	})
	
	//필수입력칸 입력
	$('#name').blur(function(){
		if($('#name').val() == ''){
			$('#nameMgs').text('이름을 입력해 주세요')
                 		.css("color", "red")
	        $('#nameck').val("false")	
		}else{
			$('#nameMgs').text('')
	        $('#nameck').val("true")				
		}
	})
	
	//연락처 입력
   
    //이메일 입력
   
    //이메일 인증
    $('#chkBtn').click(function(){
		let email = $('#emailId').val()+"@"+$('#emailDomain').val()
		console.log(email)
		$.ajax({
			url: "/silhyun/emailCk?email="+email,
			type: "get",
			success: function(res){
				console.log(res)
				if(res == 'err'){
				$('#emailCkMgs').text("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.")
				                .css("color","red")
				$('#emailCk').val('false')
				$("#emailId").focus()			
				}else{
						
				$('#emailCkMgs').text('해당 이메일로 인증번호 발송이 완료되었습니다. 인증번호가 오지 않았으면 이메일 주소를 다시 확인해주세요.')
					$('#emailchk').blur(function(){
						
						if($('#emailchk').val() == res){
							$('#emailCkMgs').text('인증완료 되었습니다.')
							                .css("color","green")
							$('#emailCk').val('true')
							$('#chkBtn').attr("disabled",true)
						}else{
							$('#emailCkMgs').text('인증번호가 틀렸습니다.다시 확인해 주세요.')
							                .css("color","red")
							$('#emailCk').val('false')						
						}
						
						
					})
					}
				
			},
			error: function(err){
				console.log(err)
					$('#emailCkMgs').text('이메일 주소가 올바르지 않습니다.')
	                .css("color","red")
						$('#emailCk').val('false')	
			}
		})
		
	})
    
	
	
})