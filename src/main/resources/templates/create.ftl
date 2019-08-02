<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <h1>Create post</h1>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <label for="title">Заголовок</label>
            <input type="text" class="form-control" name="title" required  placeholder="Заголовок"/>
        </div>
        <div class="form-group">
            <label for="description">Текст</label>
            <textarea rows="15" class="form-control" name="text" ></textarea>
        </div>
        <div class="form-group">
            <label for="InputTag">Тэги</label>
            <input  class="form-control" type="text" name="tag" placeholder="Тэги" />
        </div>
        <div class="form-group">
            <button type="submit"  class="btn btn-primary">Добавить</button>
            </button>
            <button class="btn btn-default">
                Отмена
            </button>
        </div>
    </form>
<@l.logout/>
<span><a href="/user"> User list</a></span>
</div>
</@c.page>