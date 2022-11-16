
$(function(){

//'댓글 추가' 버튼이 눌렸을때
	$('#replyConfirm').click(function(){
		//사용자 입력값 받아오기
		/*var param = { bno : $('#bno').val(), 
					  replyer : $('#replyer').val(), 
					  reply: $('#reply').val()
					  };*/
		
		var param =$('#replyFrm').serialize();
		//alert(param);
		//console.log(param);
		
		$.ajax({
			type :'post',
			url: '../replies/new',
			data:param,
			success:function(result){
			//alert(result);
			$('#reply').val('');
			replyList();
			},
			error :function(err){
			alert('error');
			console.log(err);
			}
		
		});
	
	
	});

	replyList();
	function replyList(){
	
	$.ajax({
		type:'get',
		url:'../replies',
		//data : 보내는 데이터 없음
		dataType : 'json', //라이브러리필요
		success : function(result){
			//alert('result');
			console.log(result);
			
			let replyTable =  $('#replyList');
			replyTable.empty();
			
			for(row of result){
				//console.log(row);	
				var tr = $('<tr/>');	
				tr.append($('<td/>').html(row['rno']) );
				tr.append($('<td/>').html(row['bno']) );
				tr.append($('<td/>').html(row['reply']) );
				tr.append($('<td/>').html(row['replyer']) );
				tr.append($('<td/>').html(row['replydate']) );
				//<tr><td></td></tr>
				tr.append('<td><button class="delete">삭제</button></td>');
				tr.append('<td><button class="modify">수정</button></td>');
				replyTable.append(tr);
					
			}
			
		},
		error : function(err){
		alert('error');
		console.log(err);
		}
	
	});
	
	
	}//end of replyList

//삭제 버튼을 클릭했을때
//★동적으로 생성된 버튼은 일반적인 이벤트 발생 안됨
//----->on()


/*$('.delelte').on('click', function(){
	alert('ok');

});*/

$('#replyList').on('click', '.delete', function(){
	var btn= $(this);
	
	var rno = $(this).parents('tr').children().eq(0).text();
	//alert(rno);
	
	$.ajax({
		type:'delete',
		url:'../replies/' + rno,
		success: function(result){
			replyList();
		},
		error : function(err){
			elert('에러');
		}	

	});
	
$('#replyList').on('click', '.modify', function(){
	var btn= $(this);
	
	var rno = $(this).parents('tr').children().eq(0).text();
	//alert(rno);
	
	$.ajax({
		type:'delete',
		url:'../replies/' + rno,
		success: function(result){
			replyList();
		},
		error : function(err){
			elert('에러');
		}	

	});	
	
	
	
});

});



});