try {
	$(document).ready(function () {
		select2(); //Hace que el selector de "destinos" se transforme en un selector con filtro incluido 
		clickChecked(); //Al cliquear un valor de filtros, le agrega una clase "checked" al contenedor padre, con la intención que se pueda estilizar la caja completa
		toolsUpdate(); //Actualiza el valor seleccionado de los selectores herramientas que están arriba del listado
		headingClick(); //Funcionalidades para las cajas colapsables del sidebar y ficha en los filtros
		sticky_aside();


		//Activa la funcionalidad de tooltips de bootstrap
		$('[data-toggle="tooltip"]').tooltip();

		// execute above function
		var thisIndex;
		window.picItems = [];
		var $pswp = $('.pswp')[0];

		$('.fotos-galeria').each(function (e) {
			//			thisIndex = e+1;
			thisIndex = $(this).attr('id').split('fotos-galeria-')[1];
			var $pic = $(this);
			var getItems = function () {
				var items = [];
				$pic.find('a').each(function () {
					var $href = $(this).attr('href'),
					    $size = $(this).data('size').split('x'),
					    $width = $size[0],
					    $height = $size[1];

					var item = {
						src: $href,
						w: $width,
						h: $height
					}

					items.push(item);
				});
				return items;
			}

			picItems[thisIndex] = getItems();
			console.log(thisIndex + ': ' + picItems[thisIndex]);


		});
		$('.abre-galeria').on('click', function (e) {
			e.preventDefault();
			var target = $(this).data('target').split('fotos-galeria-')[1];
			var $index = 0;
			var options = {
				index: $index,
				bgOpacity: 0.9,
				showHideOpacity: true,
				captionEl: false,
				shareEl: false,
				tapToClose: true,
				mainClass: 'pswp--minimal--dark'
			}

			console.log(target);

			// Initialize PhotoSwipe
			var lightBox = new PhotoSwipe($pswp, PhotoSwipeUI_Default, picItems[target], options);
			lightBox.init();
		});
	})
} catch (err) {
	//Errores
	console.log(err);
}