<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<header>

	<nav class="navbar navbar-fixed-top bs-docs-nav" role="banner">


		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#arrejunto"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Meetstoric</a>
			</div>

			<div class="collapse navbar-collapse"
				id="arrejunto">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/meetstoric/mainView"
						class="top_button" title="mainView">Inicio<span class="sr-only">(current)</span></a></li>
					<li><a href="/meetstoric/citas" class="top_button"
						title="Citas">Citas</a></li>
					<li><a href="/meetstoric/sugerencias" class="top_button"
						title="Recomendaciones">Sugerencias</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="/meetstoric/cierreSesion" class="top_button"
						onclick="" title="Cerrar Sesión">Cerrar Sesión</a></li>
					<li><a
						href="<%=response.encodeURL("profile?id=" + user.getId())%>"
						class="top_button" onclick="" title="Mi perfil">Mi Perfil</a></li>
				</ul>
			</div>
		</div>





	</nav>
</header>