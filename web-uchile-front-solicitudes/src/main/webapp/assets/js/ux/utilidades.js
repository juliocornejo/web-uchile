//Al cliquear un valor de filtros, le agrega una clase "checked" al contenedor padre, con la intención que se pueda estilizar la caja completa
var clickChecked = function () {
	$('.has-checkeable :input').on('change', function () {
		var $el = $(this);
		var name = $el.prop('name');
		if ($el.prop('type') == 'radio') {
			$('input[name="' + name + '"]').closest('.radio').removeClass('checked');
			$('input[name="' + name + '"]:checked').closest('.radio').addClass('checked');
		} else {
			if ($el.is(':checked')) {
				$el.closest('.checkbox').addClass('checked');
			} else {
				$el.closest('.checkbox').removeClass('checked');
			}
		}
	}).change();
}

//En mobile, los selectores "tipo moneda" y "ordenar" se cambian a botones, pero al presionarlos, abre el select por defecto del navegador
//Por ende, al cambiar el selector, se actualiza el texto del botón.
var toolsUpdate = function () {
	$('#tools select').on('change', function () {
		var val = $(this).find('option:selected').text();
		$(this).parent().find('.btn span').text(val);
	}).change();
}

//Función para cambiar la clase del cotenendor cuando se colapsan los elementos.
//Aplicado sobre todo en el sidebar para los filtros y búsqueda
var headingClick = function () {
	$('.heading-has-collap').each(function () {
		var target = $(this).find('button').data('target');
		var heading = $(this);
		var headingParent = heading.closest('.box-sidebar');
		$('[data-toggle="collapse"][data-target="' + target + '"]').on('click', function () {
			heading.addClass('clicked');
			headingParent.addClass('box-sidebar-shown');
			if (!$(target).is(':visible')) {
				heading.addClass('collap-shown');
				headingParent.addClass('box-sidebar-shown');
			} else {
				heading.removeClass('collap-shown');
				headingParent.removeClass('box-sidebar-shown');
			}
		});

		$('[data-toggle="appear"][data-target="' + target + '"]').on('click', function () {
			heading.addClass('clicked');
			headingParent.addClass('box-sidebar-shown');
			if (parseFloat($(target).css('left')) > 0) {
				heading.addClass('collap-shown');
				headingParent.addClass('box-sidebar-shown');
				$(target).addClass('appear');
				$('body').addClass('oflow-mob');
			} else {
				heading.removeClass('collap-shown');
				headingParent.removeClass('box-sidebar-shown');
				$(target).removeClass('appear');
				console.log('ocultando');
				$('body').removeClass('oflow-mob');
			}
		});
	});
}

//Al ajusta la pantalla, se eliminan o agregan algunas clases de los contenedor colapsables
//Por el momento, no se debería ocupar, ya que se resuelve todo por CSS
var onResize = function () {
	var temp = false;
	jQuery(window).on('resize', function () {
		var w = $(window).width();
		if (!$('.heading-has-collap').hasClass('clicked')) {
			if (w < 992 && temp != true) {
				$('.heading-has-collap').removeClass('collap-shown').parent().find('.collapse').removeClass('in');
				temp = true;
			} else if (w >= 992 && temp != false) {
				$('.heading-has-collap.desk-collap-visible').addClass('collap-shown').parent().find('.collapse').addClass('in');
				temp = false;
			}
		}
	}).resize();
};

//Función que le agrega las clases del selector original al nuevo selector transformado por otro jquery.
//El selector transformado es que le agrega la funcion para filtrar dentro del mismo listado
var select2 = function () {
	var select = $('.select-filterJS');
	if (select.length > 0) {
		var select_class = select.attr('class');
		select.select2();
		var new_sel = select.next('.select2');
		var sel_class = new_sel.attr('class');
		sel_class = sel_class + ' ' + select_class;
		new_sel.attr('class', sel_class);
	}
}

//Función para que la caja de precio quede fixed al momento de hacer scroll
function sticky_aside() {
	var sticky = $('.sticky');
	sticky.each(function () {
		var este = $(this);
		var sticky_inner = este.find('.sticky-inner'),
		    sticky_parent = este.closest('.parent-sticky');

		if (sticky_parent.length > 0 && sticky_inner.length > 0) {
			$(window).on('mousewheel scroll resize', function () {
				var window_top = $(window).scrollTop(),
				    window_height = $(window).height(),
				    sticky_top = este.offset().top,
				    sticky_inner_top_rel = sticky_inner.offset().top,
				    sticky_parent_pos_bottom = sticky_parent.offset().top + sticky_parent.height() + parseFloat(sticky_parent.css('padding-top')),
				    result = sticky_inner.outerHeight() - window_height;

				sticky_parent_pos_bottom = sticky_parent_pos_bottom - result;

				if (window_top >= sticky_top && (window_top + window_height) < sticky_parent_pos_bottom) {
					//Si la caja se topa con la parte superior de la ventana y no choque con la parte de abajo del contenedor
					sticky_inner.css('top', window_top - sticky_top);
				} else if (window_top < sticky_top) {
					//Si la caja está mas abajo que la parte superior de la ventana
					sticky_inner.css('top', 0);
				} else if ((window_top + window_height) > sticky_parent_pos_bottom) {
					//Si la caja está mas arriba que la parte superior de la ventana
					sticky_inner.css('top', sticky_parent.height() - sticky_inner.outerHeight());
				}

			});
		}
	})
}

//Funcionalidad para activar los sliders del sitio
var swiper = function (eleID, args) {
	if (typeof args != "undefined") {
		if ($(eleID).length > 0 && $(eleID).find('.swiper-slide').length > 1) {
			var $next = eleID + ' .swiper-button-next';
			var $prev = eleID + ' .swiper-button-prev';
			var $pag = eleID + ' .swiper-pagination';

			args.prevButton = $prev;
			args.nextButton = $next;
			args.pagination = $pag;

			window.slider[eleID] = new Swiper(eleID, args);

			$(eleID).hover(function () {
				slider[eleID].stopAutoplay();
			}, function () {
				slider[eleID].startAutoplay();
			})
		}
	}
}



//Funcionalidad para galerías tipo modal en los flujos
/*
var initPhotoSwipeFromDOM = function (gallerySelector) {

	// parse slide data (url, title, size ...) from DOM elements 
	// (children of gallerySelector)
	var parseThumbnailElements = function (el) {
		var thumbElements = el.childNodes,
		    numNodes = thumbElements.length,
		    items = [],
		    figureEl,
		    linkEl,
		    size,
		    item;

		for (var i = 0; i < numNodes; i++) {

			figureEl = thumbElements[i]; // <figure> element

			// include only element nodes 
			if (figureEl.nodeType !== 1) {
				continue;
			}

			linkEl = figureEl.children[0]; // <a> element

			size = linkEl.getAttribute('data-size').split('x');

			// create slide object
			item = {
				src: linkEl.getAttribute('href')
				//				w: parseInt(size[0], 10),
				//				h: parseInt(size[1], 10)
			};



			if (figureEl.children.length > 1) {
				// <figcaption> content
				item.title = figureEl.children[1].innerHTML;
			}

			if (linkEl.children.length > 0) {
				// <img> thumbnail element, retrieving thumbnail url
				item.msrc = linkEl.children[0].getAttribute('src');
			}

			item.el = figureEl; // save link to element for getThumbBoundsFn
			items.push(item);
		}

		return items;
	};

	// find nearest parent element
	var closest = function closest(el, fn) {
		return el && (fn(el) ? el : closest(el.parentNode, fn));
	};

	// triggers when user clicks on thumbnail
	var onThumbnailsClick = function (e) {
		e = e || window.event;
		e.preventDefault ? e.preventDefault() : e.returnValue = false;

		var eTarget = e.target || e.srcElement;

		// find root element of slide
		var clickedListItem = closest(eTarget, function (el) {
			return (el.tagName && el.tagName.toUpperCase() === 'FIGURE');
		});

		if (!clickedListItem) {
			return;
		}

		// find index of clicked item by looping through all child nodes
		// alternatively, you may define index via data- attribute
		var clickedGallery = clickedListItem.parentNode,
		    childNodes = clickedListItem.parentNode.childNodes,
		    numChildNodes = childNodes.length,
		    nodeIndex = 0,
		    index;

		for (var i = 0; i < numChildNodes; i++) {
			if (childNodes[i].nodeType !== 1) {
				continue;
			}

			if (childNodes[i] === clickedListItem) {
				index = nodeIndex;
				break;
			}
			nodeIndex++;
		}



		if (index >= 0) {
			// open PhotoSwipe if valid index found
			openPhotoSwipe(index, clickedGallery);
		}
		return false;
	};

	// parse picture index and gallery index from URL (#&pid=1&gid=2)
	var photoswipeParseHash = function () {
		var hash = window.location.hash.substring(1),
		    params = {};

		if (hash.length < 5) {
			return params;
		}

		var vars = hash.split('&');
		for (var i = 0; i < vars.length; i++) {
			if (!vars[i]) {
				continue;
			}
			var pair = vars[i].split('=');
			if (pair.length < 2) {
				continue;
			}
			params[pair[0]] = pair[1];
		}

		if (params.gid) {
			params.gid = parseInt(params.gid, 10);
		}

		return params;
	};

	var openPhotoSwipe = function (index, galleryElement, disableAnimation, fromURL) {
		var pswpElement = document.querySelectorAll('.pswp')[0],
		    gallery,
		    options,
		    items;

		items = parseThumbnailElements(galleryElement);

		// define options (if needed)
		options = {

			// define gallery index (for URL)
			galleryUID: galleryElement.getAttribute('data-pswp-uid'),

			getThumbBoundsFn: function (index) {
				// See Options -> getThumbBoundsFn section of documentation for more info
				var thumbnail = items[index].el.getElementsByTagName('img')[0], // find thumbnail
				    pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
				    rect = thumbnail.getBoundingClientRect();

				return {
					x: rect.left,
					y: rect.top + pageYScroll,
					w: rect.width
				};
			}

		};

		// PhotoSwipe opened from URL
		if (fromURL) {
			if (options.galleryPIDs) {
				// parse real index when custom PIDs are used 
				// http://photoswipe.com/documentation/faq.html#custom-pid-in-url
				for (var j = 0; j < items.length; j++) {
					if (items[j].pid == index) {
						options.index = j;
						break;
					}
				}
			} else {
				// in URL indexes start from 1
				options.index = parseInt(index, 10) - 1;
			}
		} else {
			options.index = parseInt(index, 10);
		}

		// exit if index not found
		if (isNaN(options.index)) {
			return;
		}

		if (disableAnimation) {
			options.showAnimationDuration = 0;
		}

		// Pass data to PhotoSwipe and initialize it
		gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default, items, options);
		gallery.init();
	};

	// loop through all gallery elements and bind events
	var galleryElements = document.querySelectorAll(gallerySelector);

	for (var i = 0, l = galleryElements.length; i < l; i++) {
		galleryElements[i].setAttribute('data-pswp-uid', i + 1);
		galleryElements[i].onclick = onThumbnailsClick;
	}

	// Parse URL and open gallery if it contains #&pid=3&gid=1
	var hashData = photoswipeParseHash();
	if (hashData.pid && hashData.gid) {
		openPhotoSwipe(hashData.pid, galleryElements[hashData.gid - 1], true, true);
	}
};
*/