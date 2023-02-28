let main = {
    init : function () {
        let _this = this;
        $("#btn-save").on('click', function () {
           console.log(("::::click 함수 실행::::"))
            _this.save()
        });

        $("#btn-update").on('click', function () {
            _this.update();
        })

        $('#btn-delete').on('click', function () {
            _this.delete();
        })
    },

    save : function () {
        let data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type:'POST',
            url : '/api/v1/posts',
            contentType : 'application/json',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.')
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    update : function() {
        let data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        console.log("::::::::::" + data + ":::::::::");
        let id = $('#id').val();
        alert(data.title)

        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/'+id,
            dataType : 'json',
            contentType : 'application/json',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.'+data);
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },

    delete : function () {
        let data = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json',
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href ='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

}
main.init();