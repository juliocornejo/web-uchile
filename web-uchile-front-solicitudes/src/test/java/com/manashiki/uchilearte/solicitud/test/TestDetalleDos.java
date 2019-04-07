//package com.manashiki.uchilearte.solicitud.test;
//
//import java.util.Date;
//
//import org.junit.Test;
//
//import com.producto.client.angular.ClientProducto_FlujoHotel;
//import com.producto.dto.model.request.BusquedaDTO;
//import com.producto.dto.model.request.RequestProductoDTO;
//import com.producto.dto.model.request.SeleccionProductoDTO;
//import com.producto.dto.model.response.ProductoViewDTO;
//
//public class TestDetalleDos {
//
//                @Test
//                public void ejecutarPrueba() {
//                               System.out.println("Inicio ejecutarPrueba " + new Date());
//                               //ejecutarPortal();
//                               TestDetalleDos testCliente_Hotel = new TestDetalleDos();
//                               testCliente_Hotel.flujoTotal();
//
//                               System.out.println("Fin ejecutarPrueba " + new Date());
//
//                }
//
//                public void flujoTotal() {
//
//                               //ZoneDTO metZoneDTO = buscarZonaBusqueda();
//
//                               //if(metZoneDTO!=null && !metZoneDTO.getStrName().equals("")){
//
//
//                                               /*********************************************************************/
//                                               System.out.println("INI - obtenerDetalleHotelParteDos");
//                                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
//                                               ProductoViewDTO reqProductoViewDTO = new ProductoViewDTO();
//                                               SeleccionProductoDTO seleccionProductoDTO = new SeleccionProductoDTO();
//                                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
//                                               BusquedaDTO busquedaDTO = new BusquedaDTO();
//                                               int idxOpcion=0;
//
//                                               /***DATOS DE TRANSACCIONALIDAD AL PRODUCTO***/
//                                               reqProductoViewDTO.setIdBusquedaTransaccional(288); //el idBusqueda(desde el productoViewDTOParteUno)
//                                               reqProductoViewDTO.setIdProductoTransaccional(282); //el idProducto(desde el productoViewDTOParteUno)
//                                               reqProductoViewDTO.setIdDetalleProductoTransaccional(83); // id detalle(desde el productoViewDTOParteUno)
//                                               /***DATOS DE TRANSACCIONALIDAD AL PRODUCTO***/
//                                               //****INDICE de OPCION DE HOTEL SELECCIONADO*******/
//                                               String portalCode="CL";
//                                               busquedaDTO.setPortalCode(portalCode);//Agregar el PortalCode
//                                               seleccionProductoDTO = new SeleccionProductoDTO();
//                                               idxOpcion = 1;
//                                               seleccionProductoDTO.setIndiceOpcionHotelSeleccionada(idxOpcion);
//                                               busquedaDTO.setSeleccionProductoDTO(seleccionProductoDTO);// opcion de hotel Seleccionada.
//                                               //****INDICE de OPCION DE HOTEL SELECCIONADO*******/
//                                               requestHijoDTO.setProductoViewDTO(reqProductoViewDTO);
//                                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
//
//                                               ProductoViewDTO productoViewDTOParteDos = clientProducto_FlujoHotel.buscarDetalleProductoHotelProveedor(requestHijoDTO);
//                                               System.out.println("FIN - obtenerDetalleHotelParteDos "+productoViewDTOParteDos.getIdDetalleProductoTransaccional());
//
//
//                               }
//                               /*Ficha que se muestra en el componente Web*/
//                }
//
//                /**** Obtener Ficha ***************************************/
////
////                private int instanteBusqueda=0;
////                public ProductoViewDTO obtenerDetalleHotelParteUno(NegocioTransaccionalViewDTO negocioViewDTO) {
////                               /*********************************************************************/
////                               System.out.println("INI - obtenerDetalleHotelParteUno");
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               //UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////
////                               ProductoViewDTO productoViewDTO = new ProductoViewDTO();
////
////                               productoViewDTO.setIdProductoTransaccional(negocioViewDTO.getIdProductoTransaccional()); 
////                               //BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal(); //Solo Necesitamos el PortalCode
////
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////
////                               productoViewDTO = clientProducto_FlujoHotel.buscarDetalleProductoHotelPersistencia(requestHijoDTO);
////                               System.out.println("FIN - obtenerDetalleHotelParteUno "+productoViewDTO.getIdBusquedaTransaccional()+" - "+productoViewDTO.getIdProductoTransaccional());
////                               return productoViewDTO;
////                }
////
////
////                public ProductoViewDTO obtenerDetalleHotelParteDos(ProductoViewDTO productoViewDTO) {
////                               /*********************************************************************/
////                               System.out.println("INI - obtenerDetalleHotelParteDos");
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////                               int idxOpcion=0;
////                               //            productoViewDTO.setIdBusqueda(getInstanteBusqueda());
////
////                               //****INDICE de OPCION DE HOTEL SELECCIONADO*******/
////                               idxOpcion = utilidadesMostrarTest.retonarIndice(productoViewDTO);
////
////                               for(int opc=0;opc<productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().size();opc++){
////                                               productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).setSeleccionada(false);
////                               }
////                                productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(idxOpcion).setSeleccionada(true);
////
////                               BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal(); //Solo Necesitamos el PortalCode
////                               //****INDICE de OPCION DE HOTEL SELECCIONADO*******/
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////
////                               productoViewDTO = clientProducto_FlujoHotel.buscarDetalleProductoHotelProveedor(requestHijoDTO);
////                               System.out.println("FIN - obtenerDetalleHotelParteDos");
////                               return productoViewDTO;
////                }
////
////                public NegocioTransaccionalViewDTO almacenarProductoSeleccionadoFichaHotel(ProductoViewDTO productoViewDTO){
////                               System.out.println("INI - almacenarProductoSeleccionadoFichaHotel "+productoViewDTO.getIdProductoTransaccional());
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               NegocioTransaccionalViewDTO negocioViewDTO = new NegocioTransaccionalViewDTO();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////
////                               BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal(); //Solo Necesitamos el PortalCode
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////                               //Pasar solo la Opcion Seleccionada,
////                               HotelOpcionViewDTO tempHtlOpcView = new HotelOpcionViewDTO();
////                               for(HotelOpcionViewDTO htlOpcView : productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView()){
////                                               if(htlOpcView.isSeleccionada()==true){
////                                                               tempHtlOpcView = htlOpcView;
////                                                               break;
////                                               }
////                               }
////
////                               productoViewDTO.getListaHotelViewDTO().get(0).setListaHotelOpcionView(new ArrayList<HotelOpcionViewDTO>());
////                                productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().add(tempHtlOpcView);
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               //Pasar solo la Opcion Seleccionada,
////
////                               negocioViewDTO = clientProducto_FlujoHotel.almacenarSeleccionDetalleProductoHotel(requestHijoDTO);
////                               System.out.println("FIN - almacenarProductoSeleccionadoFichaHotel neg:"+negocioViewDTO.getIdNegocioTransaccional());
////                               return negocioViewDTO;
////                }
////
////                public ProductoViewDTO obtenerSeleccionProductoViewDTOCompraHotel(NegocioTransaccionalViewDTO negocioViewDTO) {
////                               /*********************************************************************/
////                               System.out.println("INI - obtenerSeleccionProductoViewDTOCompraHotel");
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////
////                               ProductoViewDTO productoViewDTO = new ProductoViewDTO();
////
////                               productoViewDTO.setIdNegocioTransaccional(negocioViewDTO.getIdNegocioTransaccional()); 
////                               //            productoViewDTO.setIdProducto(negocioViewDTO.getIdProducto()); 
////                               //            productoViewDTO.setIdBusqueda(negocioViewDTO.getIdBusqueda()); //No Ocupamos la Busqueda en este Metodo
////                               BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal(); //Solo Necesitamos el PortalCode
////
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////
////                               productoViewDTO = clientProducto_FlujoHotel.obtenerSeleccionProductoViewDTOCompraHotel(requestHijoDTO);
////                               System.out.println("FIN - obtenerSeleccionProductoViewDTOCompraHotel "+productoViewDTO.getIdBusquedaTransaccional()+" - "+productoViewDTO.getIdProductoTransaccional());
////                               return productoViewDTO;
////                }
////
////                public BusquedaDTO obtenerBusquedaProductoViewDTOCompraHotel(NegocioTransaccionalViewDTO negocioViewDTO) {
////                               /*********************************************************************/
////                               System.out.println("INI - obtenerBusquedaProductoViewDTOCompraHotel");
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////
////                               ProductoViewDTO productoViewDTO = new ProductoViewDTO();
////
////                               //            productoViewDTO.setIdNegocio(negocioViewDTO.getIdNegocio()); 
////                               //            productoViewDTO.setIdProducto(negocioViewDTO.getIdProducto()); 
////                               productoViewDTO.setIdBusquedaTransaccional(negocioViewDTO.getIdBusquedaTransaccional()); //solo el id de busqueda.
////                               BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal(); //Solo Necesitamos el PortalCode
////
////                               //            setInstanteBusqueda(negocioViewDTO.getIdBusqueda());
////
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////
////                               busquedaDTO = clientProducto_FlujoHotel.obtenerBusquedaProductoViewDTOCompraHotel(requestHijoDTO);
////                               System.out.println("FIN - obtenerBusquedaProductoViewDTOCompraHotel");
////
////                               return busquedaDTO;
////                }
////
////                public QuoteDTO reservaProductoViewDTOCompraHotel(ProductoViewDTO productoViewDTO,BusquedaDTO busquedaDTO) {
////                               System.out.println("..PASO 3 generar la RESERVA..");
////                               ClientProducto_FlujoHotel clientProducto_FlujoHotel = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesPoderSupremo = new UtilidadesPoderSupremo();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////                               ProductPriceDTO productPriceDTO;
////                               PaymentAttemptDTO paymentAttemptDTO;
////
////                               List<HotelOpcionDescripcionPoliticaCancelacionDTO> listaHotelOpcionDescripcionPoliticaCancelacionDTO = new ArrayList<HotelOpcionDescripcionPoliticaCancelacionDTO>();
////                               listaHotelOpcionDescripcionPoliticaCancelacionDTO = productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getHotelPoliticaCancelacionViewDTO().getListaHotelOpcionDescripcionPoliticaCancelacionDTO();
////
////                               JOptionPane.showMessageDialog(null,"��Leer La Consola!!");
////                               for (HotelOpcionDescripcionPoliticaCancelacionDTO hotPolCanDTO : listaHotelOpcionDescripcionPoliticaCancelacionDTO) {
////                                               System.out.println("PC : " +hotPolCanDTO.getOrdenDescripcionRegla() +" - "+ hotPolCanDTO.getDescripcionCancelacion());
////                               }
////
////                               DatosCompraDTO datosCompraDTO = new DatosCompraDTO();
////                               //            requestBookingDTO.setIdLiferay(portalIdPrueba);
////                               busquedaDTO = utilidadesPoderSupremo.generarBusqueda();
////                               //Los datos de compra de los Pasajeros estan en el generarBusqueda
////                               //Generar la Busqueda.
////                               datosCompraDTO.setFueraPais(false);
////                               datosCompraDTO.setRecibirNotificacionesEmail(false);
////
////                               ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
////                               contactInformationDTO.setEmail("elimino.gente.por.dinero@gmail.com");
////                               contactInformationDTO.setPhones(new ArrayList<ContactInformationPhoneDTO>());
////
////                               ContactPhoneDTO contactPhoneDTO = new ContactPhoneDTO();
////                               contactPhoneDTO.setIdContactPhoneType(PhoneType.CellPhone.getValue());
////                               contactPhoneDTO.setPhone("232421526");
////
////                               ContactInformationPhoneDTO contactInformationPhoneDTO = new ContactInformationPhoneDTO();
////                               contactInformationPhoneDTO.setContactPhoneType(PhoneType.CellPhone.getValue());
////                               contactInformationPhoneDTO.setNumber("+56988478877");
////                               contactInformationDTO.getPhones().add(contactInformationPhoneDTO);
////
////                               datosCompraDTO.setContactPhoneDTO(contactPhoneDTO);
////                               datosCompraDTO.setContactInformationDTO(contactInformationDTO);
////
////                               paymentAttemptDTO = new PaymentAttemptDTO();
////                               paymentAttemptDTO.setQuotas(1); //TODO �Que Es?
////                               paymentAttemptDTO.setPaymentAttemptType(1);  //TODO �Que Es?
////                               BigDecimal quotaValue = new BigDecimal(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaPrecioHotelModel().get(0).getPrecioTotalHotel());
////                               paymentAttemptDTO.setQuotaValue(quotaValue);
////
////                               List<ProductPriceDTO> listaProductPriceDTO = new ArrayList<ProductPriceDTO>();
////                               productPriceDTO = new ProductPriceDTO();
////                               productPriceDTO.setChangeType(new BigDecimal(0));
////                               productPriceDTO.setCommissionCost(new BigDecimal(0));
////                               productPriceDTO.setCurrency("USD");
////                               productPriceDTO.setDiscountCost(new BigDecimal(0));
////                               productPriceDTO.setFee(new BigDecimal(0));
////                               productPriceDTO.setFeeService(new BigDecimal(0));
////                               productPriceDTO.setFinancingInterest(new BigDecimal(0));
////                               productPriceDTO.setNetCost(new BigDecimal(0));
////                               productPriceDTO.setTax(new BigDecimal(0));
////                               productPriceDTO.setTaxAfip(new BigDecimal(0));
////                               productPriceDTO.setTotalCost(new BigDecimal(0));
////                               listaProductPriceDTO.add(productPriceDTO);
////
////                               productPriceDTO = new ProductPriceDTO();
////                               productPriceDTO.setChangeType(new BigDecimal(0));
////                               productPriceDTO.setCommissionCost(new BigDecimal(0));
////                                productPriceDTO.setCurrency(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaPrecioHotelModel().get(0).getCurrencyHotel());
////                               productPriceDTO.setDiscountCost(new BigDecimal(0));
////                               productPriceDTO.setFee(new BigDecimal(0));
////                               productPriceDTO.setFeeService(new BigDecimal(0));
////                               productPriceDTO.setFinancingInterest(new BigDecimal(0));
////                               productPriceDTO.setNetCost(new BigDecimal(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaPrecioHotelModel().get(0).getPrecioTotalHotel()));
////                               productPriceDTO.setTax(new BigDecimal(0));
////                               productPriceDTO.setTaxAfip(new BigDecimal(0));
////                               productPriceDTO.setTotalCost(new BigDecimal(0));
////                               listaProductPriceDTO.add(productPriceDTO);
////                               // //CLP PESO CHILENO
////                               datosCompraDTO.setListaProductPriceDTO(listaProductPriceDTO);
////
////                               List<OffLineDTO> listaOffLineDTO = new ArrayList<OffLineDTO>();
////                               OffLineDTO offLineDTO = new OffLineDTO();
////                               //Para pago OffLine
////                               offLineDTO.setAddress("");
////                               offLineDTO.setBirthDate(new Date());
////                               offLineDTO.setCardNumber("4051885600446623"); //TODO NUmero de Tarjeta Para reintento de Pago, solo se almacena en la base de datos
////                               offLineDTO.setCardPassword("1234");
////                               offLineDTO.setCellPhone("+56988478877");
////                               offLineDTO.setEmailAddress("julio.i.cornejo.g@gmail.com");
////                               offLineDTO.setExpirationMonth(1);
////                               offLineDTO.setExpirationYear(2017);
////                               offLineDTO.setIdentifier("22.222.222-2");
////                               offLineDTO.setIdIdentifierType(4);
////
////                               offLineDTO.setIssuingBank("Banco de Prueba");
////                               offLineDTO.setNameOFF("nameOFF");
////                               offLineDTO.setNoResident(true);
////                               offLineDTO.setPhone("344324324");
////
////                               listaOffLineDTO.add(offLineDTO);
////                               paymentAttemptDTO.setOffLines(listaOffLineDTO);
////                               datosCompraDTO.setPaymentAttemptDTO(paymentAttemptDTO);
////
////                               requestHijoDTO.setDatosCompraDTO(datosCompraDTO);
////                               requestHijoDTO.setProductoViewDTO(productoViewDTO);
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////
////                               QuoteDTO quoteDTO= clientProducto_FlujoHotel.reservarProductoViewDTOCompraHotel(requestHijoDTO);
////                               System.out.println("FIN - obtenerBusquedaProductoViewDTOCompraHotel");
////
////                               return quoteDTO;
////                }
////                //            /*********************************************************************/
////                //            System.out.println("..PASO 3 generar la RESERVA..");
////                //
////                //            List<HotelPoliticaCancelacionViewDTO> listaHotelPoliticaCancelacionViewDTO = new ArrayList<HotelPoliticaCancelacionViewDTO>();
////                //            listaHotelPoliticaCancelacionViewDTO = productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaHotelPoliticaCancelacionViewDTO();
////                //            
////                //            BusquedaDTO busquedaDTO = new BusquedaDTO();
////                //            
////                //            JOptionPane.showMessageDialog(null,"Leer La Consola");
////                //            for (HotelPoliticaCancelacionViewDTO hotPolCanDTO : listaHotelPoliticaCancelacionViewDTO) {
////                //                                           System.out.println("PC : " +hotPolCanDTO.getOrdenDescripcionRegla() +" - "+ hotPolCanDTO.getDescripcionCancelacion());
////                //                           }
////                //
////                //
////                //            ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
////                //            
////                //            RequestBookingDTO requestBookingDTO = new RequestBookingDTO();
////                //            requestBookingDTO.setIdLiferay(portalIdPrueba);
////                //            requestBookingDTO.setOriginCode("");
////                //            requestBookingDTO.setDestinyCode(busquedaDTO.getDestinyCode()); // Se esta Enviando  la Zona en el Request del
////                //            requestBookingDTO.setOutOfCountry(false); // Variables del formulario Compra
////                //            requestBookingDTO.setReceiveEmailDeals(false); //Variables del formulario Compra
////                //            requestBookingDTO.setPortalCode(busquedaDTO.getPortalCode());
////                //            
////                //            requestBookingDTO.setDepartureDate(busquedaDTO.getFechaInicial());
////                //            requestBookingDTO.setReturnDate(busquedaDTO.getFechaFinal());
////                //            
////                //            ContactPhoneDTO contactPhoneDTO = new ContactPhoneDTO();
////                //            contactPhoneDTO.setIdContactPhoneType(PhoneType.CellPhone.getValue());
////                //            contactPhoneDTO.setPhone("232421526");
////                /********************** Datos del Pasajero ***************************************/
////                //
////                //            ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
////                //            // contactInformationDTO.setEmail("jigcornejo@falabella.cl");
////                //            contactInformationDTO.setEmail("cadiz.v@gmail.com");
////                //            contactInformationDTO.setPhones(new ArrayList<ContactInformationPhoneDTO>());
////                //
////                //            ContactInformationPhoneDTO contactInformationPhoneDTO = new ContactInformationPhoneDTO();
////                //            contactInformationPhoneDTO.setContactPhoneType(PhoneType.CellPhone.getValue());
////                //            contactInformationPhoneDTO.setNumber("988478877");
////                //            contactInformationDTO.getPhones().add(contactInformationPhoneDTO);
////                //            requestBookingDTO.setContactPhoneDTO(contactPhoneDTO);
////                //            requestBookingDTO.setContactInformation(contactInformationDTO);
////                /*********************************************************************/
////                //
////                //            PaymentAttemptDTO paymentAttemptDTO = new PaymentAttemptDTO();
////                //            paymentAttemptDTO.setQuotas(1);
////                //            BigDecimal quotaValue = new BigDecimal(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaPrecioHotelModel().get(0).getPrecioTotalHotel());
////                //            paymentAttemptDTO.setQuotaValue(quotaValue);
////                //            paymentAttemptDTO.setPaymentAttemptType(1);
////                /****************** AUTORIZACION ES DESPUES DE LA RESERVA **********************************/
////                /****************** AUTORIZACION ES DESPUES DE LA RESERVA **********************************/
////                //            paymentAttemptDTO.setNpsPaymentAttempts(new ArrayList<NPSPaymentAttemptDTO>());
////                //
////                //            paymentAttemptDTO.getNpsPaymentAttempts().add(0, new NPSPaymentAttemptDTO());
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setCommerceCode("dsds");
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdAirline(212);
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdCountry(1);
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdFlowType(2);
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdNPSBank(1);
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdNPSCard(1);
////                //            paymentAttemptDTO.getNpsPaymentAttempts().get(0).setQuotas(2);
////                //            requestBookingDTO.setPaymentAttempt(paymentAttemptDTO);
////                // //USD DOLAR GRINGO
////                //            requestBookingDTO.setProductPriceDTOs(new ArrayList<ProductPriceDTO>());
////                //            requestBookingDTO.getProductPriceDTOs().add(0, new ProductPriceDTO());
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setChangeType(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setCommissionCost(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setCurrency("USD");
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setDiscountCost(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFee(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFeeService(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFinancingInterest(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setNetCost(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTax(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTaxAfip(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTotalCost(new BigDecimal(0));
////                // //CLP PESO CHILENO
////                //            requestBookingDTO.setProductPriceDTOs(new ArrayList<ProductPriceDTO>());
////                //            requestBookingDTO.getProductPriceDTOs().add(0, new ProductPriceDTO());
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setChangeType(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setCommissionCost(new BigDecimal(0));
////                //                requestBookingDTO.getProductPriceDTOs().get(0).setCurrency(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getListaPrecioHotelModel().get(0).getCurrencyHotel());
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setDiscountCost(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFee(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFeeService(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setFinancingInterest(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setNetCost(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTax(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTaxAfip(new BigDecimal(0));
////                //            requestBookingDTO.getProductPriceDTOs().get(0).setTotalCost(new BigDecimal(0));
////                // //Offline //Datos de William Wallace. ver como los setea en el PASO 3
////
////                //            requestBookingDTO.getPaymentAttempt().setOffLines(new ArrayList<OffLineDTO>());
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().add(new OffLineDTO());
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setAddress("");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setBirthDate(new Date());
////                //                requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCardNumber("4051885600446623");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCardPassword("1234");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCellPhone("+56 999887766");
////                //                requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setEmailAddress("julio.i.cornejo.g@gmail.com");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setExpirationMonth(1);
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setExpirationYear(2017);
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIdentifier("22.222.222-2");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIdIdentifierType(4);
////                //
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIssuingBank("AMB Amro");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setNameOFF("nameOFF");
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setNoResident(true);
////                //            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setPhone("344324324");
////                //
////                // //HotelBookingDetailDTO
////                // RATE PLAN CODE MANO.....
////                //            
////                //                requestBookingDTO.setRatePlanCode(productoViewDTO.getListaHotelViewDTO().get(0).getListaHotelOpcionView().get(0).getBookingCode());
////                /*******************************************************************************/
////
////                //            requestBookingDTO.setHotelFichaDTO(hotelFichaDTO);
////                // Passenger - Passenger - Passenger
////                // El Primero de los Pasajeros va con Lider ==true.
////                //            requestBookingDTO.setPassengerDTOs(new ArrayList<PassengerDTO>());
////                /**********************************/
////                //            requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
////                //            requestBookingDTO.getPassengerDTOs().get(0).setBirthDate(new Date());
////                //            requestBookingDTO.getPassengerDTOs().get(0).setGender("M");
////                //            requestBookingDTO.getPassengerDTOs().get(0).setIdentifier("11111111-1");
////                //            requestBookingDTO.getPassengerDTOs().get(0).setIdentifierType(4);
////                //            requestBookingDTO.getPassengerDTOs().get(0).setLastName("wallace");
////                //            requestBookingDTO.getPassengerDTOs().get(0).setLider(true);
////                //            requestBookingDTO.getPassengerDTOs().get(0).setNationality("CL");
////                //            requestBookingDTO.getPassengerDTOs().get(0).setName("william");
////                //            requestBookingDTO.getPassengerDTOs().get(0).setPassengerAddress("Amunategui 695");
////                //
////                //            requestBookingDTO.getPassengerDTOs().get(0).setPassengerType(1);
////                //            requestBookingDTO.getPassengerDTOs().get(0).setAge(30);
////                //            /**********************************/
////                //            requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
////                //            requestBookingDTO.getPassengerDTOs().get(1).setBirthDate(new Date());
////                //            requestBookingDTO.getPassengerDTOs().get(1).setGender("M");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setIdentifier("22222222-2");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setIdentifierType(4);
////                //            requestBookingDTO.getPassengerDTOs().get(1).setLastName("wallace");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setLider(false);
////                //            requestBookingDTO.getPassengerDTOs().get(1).setNationality("CL");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setName("wally west");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setPassengerAddress("Amunategui 695");
////                //            requestBookingDTO.getPassengerDTOs().get(1).setPassengerType(1);
////                //            requestBookingDTO.getPassengerDTOs().get(1).setAge(30);
////                /***************************************************/
////                /*requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
////                requestBookingDTO.getPassengerDTOs().get(1).setBirthDate(new Date());
////                requestBookingDTO.getPassengerDTOs().get(1).setGender("M");
////                requestBookingDTO.getPassengerDTOs().get(1).setIdentifier("33333333-3");
////                requestBookingDTO.getPassengerDTOs().get(1).setIdentifierType(4);
////                requestBookingDTO.getPassengerDTOs().get(1).setLastName("wallace");
////                requestBookingDTO.getPassengerDTOs().get(1).setLider(false);
////                requestBookingDTO.getPassengerDTOs().get(1).setNationality("CL");
////                requestBookingDTO.getPassengerDTOs().get(1).setName("waldorfino");
////                requestBookingDTO.getPassengerDTOs().get(1).setPassengerAddress("Amunategui 695");
////                requestBookingDTO.getPassengerDTOs().get(1).setPassengerType(2);
////                requestBookingDTO.getPassengerDTOs().get(1).setAge(edadNinho1Pieza1);*/
////                /**************************************************************/
////                //            requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
////                //            requestBookingDTO.getPassengerDTOs().get(3).setBirthDate(new Date());
////                //            requestBookingDTO.getPassengerDTOs().get(3).setGender("M");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setIdentifier("44444444-4");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setIdentifierType(4);
////                //            requestBookingDTO.getPassengerDTOs().get(3).setLastName("wallace el adoptado");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setLider(false);
////                //            requestBookingDTO.getPassengerDTOs().get(3).setNationality("CL");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setName("walinho scratch");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setPassengerAddress("Amunategui 695");
////                //            requestBookingDTO.getPassengerDTOs().get(3).setPassengerType(2);
////                //            requestBookingDTO.getPassengerDTOs().get(3).setAge(edadNinho2Pieza1);
////                //            /**********************************/
////                // Retornar el Producto
////                //            WrapperProductoDto reservaHoteles = clientProducto.reservarHotel(requestBookingDTO);
////                //            return reservaHoteles.getProductoDTO();
////                // Retorna un IdQuote o algo por el Estilo
////                // Ir a ver a la Base de Datos
////                //}
////
////                /*************************************************************************/
////                //            public HotelBookingRulesRS obtenerFichaDirect(HotelResultJPDTO hotelResultJPDTO) {
////                //                           /*********************************************************************/
////                //                           System.out.println("..PASO 3 Obtener Ficha ..");
////                //                           System.out.println("ratePlanCode " + hotelResultJPDTO.getListHotelOptionJPs().get(0).getRatePlanCode());
////                //                           String rate = hotelResultJPDTO.getListHotelOptionJPs().get(0).getRatePlanCode();
////                //                           System.out.println("CodigoHotel "+ hotelResultJPDTO.getCode());
////                //                           /*********************************************************************/
////                //                           ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
////                //                           WrapperProductoDto wrapperProductoDto = new WrapperProductoDto();
////                //                           ProductoDTO metProductoDTO = new ProductoDTO();
////                //
////                //                           RequestSearchDTO requestSearchDTO = new RequestSearchDTO();
////                //                           requestSearchDTO.setIdLiferay(portalIdPrueba); // 17736
////                //                           requestSearchDTO.setAdultPassengers(1);
////                //
////                //                           Calendar departureCalendar = Calendar.getInstance();
////                //                           departureCalendar.set(anhoIniPrueba, mesIniPrueba, diaIniPrueba, 0, 0);
////                //
////                //                           long departureTime = departureCalendar.getTimeInMillis();
////                //                           Date departureDate = new Date(departureTime);
////                //                           requestSearchDTO.setDepartureDate(departureDate);
////                //
////                //                           Calendar returnCalendar = Calendar.getInstance();
////                //                           returnCalendar.set(anhoFinPrueba, mesFinPrueba, diaFinPrueba, 0, 0);
////                //
////                //                           long returnTime = returnCalendar.getTimeInMillis();
////                //                           Date returnDate = new Date(returnTime);
////                //                           requestSearchDTO.setReturnDate(returnDate);
////                //
////                //                           requestSearchDTO.setPortalCode(portalCodePrueba);
////                //                           requestSearchDTO.setDestinyCode(destinyCodePrueba); // 110723 , 17852
////                //
////                //                           requestSearchDTO.setRequestSearchHotel(new RequestSearchHotelDTO());
////                //                           requestSearchDTO.getRequestSearchHotel().setLstRoom(
////                //                                                           new ArrayList<RoomDTO>());
////                //
////                //                           /**********Adultos - Adultos *********************/
////                //                           requestSearchDTO.getRequestSearchHotel().getLstRoom().add(new RoomDTO());
////                //                           requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).setPassengers(new ArrayList<PassengerHotelDTO>());
////                //                           requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).getPassengers().add(new PassengerHotelDTO());
////                //                            requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).getPassengers().get(0).setAdult(true);
////                //                           
////                //                           /*************************************/
////                //                            //requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).getPassengers().add(new PassengerHotelDTO());
////                //                            //requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).getPassengers().get(1).setAdult(false);
////                //                            //requestSearchDTO.getRequestSearchHotel().getLstRoom().get(0).getPassengers().get(1).setAge(edadNinho1Pieza1);
////                //                           /*************************************/
////                //                           
////                //                            requestSearchDTO.getRequestSearchHotel().setRatePlanCode(hotelResultJPDTO.getListHotelOptionJPs().get(0).getRatePlanCode());
////                //                           requestSearchDTO.getRequestSearchHotel().setHotelCode(hotelResultJPDTO.getCode());
////                //
////                //                           Juniper juniper = new Juniper();
////                //                           
////                //                           //HotelOption
////                //                           HotelOptionRequestJP hotelOptionJP = new HotelOptionRequestJP();
////                //                            hotelOptionJP.setRatePlanCode(hotelResultJPDTO.getListHotelOptionJPs().get(0).getRatePlanCode());
////                //                           
////                //                           //SearchSegmentsHotelsJP
////                //                           SearchSegmentsHotelsJP searchSegmentsHotelsJP = new SearchSegmentsHotelsJP();
////                //                           
////                //                           //SearchSegmentHotelJP
////                //                           SearchSegmentHotelJP searchSegmentHotelJP = new SearchSegmentHotelJP();
////                //                           searchSegmentHotelJP.setStart(departureDate);
////                //                           searchSegmentHotelJP.setEnd(returnDate);
////                //                           
////                //                           //HotelCode
////                //                           List<String> listHotelCodes = new ArrayList<String>();
////                //                           listHotelCodes.add(hotelResultJPDTO.getCode());
////                //                           
////                //                           searchSegmentsHotelsJP.setSearchSegmentHotels(searchSegmentHotelJP);
////                //                           searchSegmentsHotelsJP.setListHotelCodes(listHotelCodes);
////                //                                                           
////                //                           HotelBookingRulesRequestJP hotelbookingRulesRequestJP = new HotelBookingRulesRequestJP();
////                //                           hotelbookingRulesRequestJP.setHotelOptionJP(hotelOptionJP);
////                //                           hotelbookingRulesRequestJP.setSearchSegmentsHotels(searchSegmentsHotelsJP);
////                //                           
////                //                           //Seteo de HotelBookingRulesRQ                          
////                //                           HotelBookingRulesRQ hotelBookingRulesRQ = new HotelBookingRulesRQ();
////                //                           hotelBookingRulesRQ.setHotelBookingRulesRequestJP(hotelbookingRulesRequestJP);
////                //                           hotelBookingRulesRQ.setPortalCode("http://vfapp.viajesfalabella.com:8080/app-parametro-ws/rest/parametro");
////                //                           
////                //                           HotelTranferJP hotelTransfer = new HotelTranferJP();
////                //                           hotelTransfer.setHotelBookingRulesRQ(hotelBookingRulesRQ);
////                //                           HotelBookingRulesRS hotelBookinRuleRS = null;
////                //                           try{
////                //                                           hotelBookinRuleRS = juniper.hotelBookingRule(hotelTransfer.getHotelBookingRulesRQ(), hotelTransfer.getParametroPdtoServicio().getUrlParametroAdapterJuniper());
////                //                           }catch(Exception e){
////                //                                           System.out.println(e);
////                //                                           e.printStackTrace();
////                //                           }
////                //                           //wrapperProductoDto = clientProducto.obtenerFicha(requestSearchDTO);
////                //                           //metProductoDTO = wrapperProductoDto.getProductoDTO();
////                //
////                //                           System.out.println("rateClanCode " + rate);
////                //                           System.out.println("Booking Code "+ metProductoDTO.getHotelFichaDTO().getHotelBookingRulesRSDTO().getResults().getListHotelResults().get(0).getListHotelOptions().get(0).getBookingCode().getValue());
////                //
////                //                           //return metProductoDTO;
//                //                           return hotelBookinRuleRS;
//                //            }
//                /*************************************************************************/
//
//                /****************** Obtener Ficha ***************************************/
//
//                /****************** PASO 3 compra-hoteles *****************************/
//                //            public ProductoDTO reserva(HotelFichaDTO hotelFichaDTO) {
//                //                           /*********************************************************************/
//                //                           System.out.println("..PASO 3 generar la RESERVA..");
//                //
//                //                           CancellationPolicyRulesJPDTO objcanPolicyRulesJPDTO = new CancellationPolicyRulesJPDTO();
//                //                           objcanPolicyRulesJPDTO = hotelFichaDTO.getHotelBookingRulesRSDTO()
//                //                                                           .getResults().getListHotelResults().get(0)
//                //                                                           .getListHotelOptions().get(0).getCancellationPolicy();
//                //
//                //                           String[] politicasCancelacion = objcanPolicyRulesJPDTO.getDescription()
//                //                                                           .split(Pattern.quote("*"));
//                //
//                //                           for (String politica : politicasCancelacion) {
//                //
//                //                                           if (politica.length() > 1) {
//                //                                                           /********** Antes de Politicas de Cancelacion *******************************/
//                //                                                           //JOptionPane.showMessageDialog(null,"Leer La Consola");
//                //                                                           System.out.println("PC currencyCode : "
//                //                                                                                          + objcanPolicyRulesJPDTO.getCurrencyCode());
//                //
//                //                                                           System.out.println("PC politica : "
//                //                                                                                          + PoderMaximo.redondeoCancellationPolicies(politica));
//                //
//                //                                                           System.out.println("PC Hora : "
//                //                                                                                          + objcanPolicyRulesJPDTO.getFirstDayCostCancellation()
//                //                                                                                          .getHour());
//                //
//                //                                                           System.out.println("PC FirstDayCan : "
//                //                                                                                          + objcanPolicyRulesJPDTO.getFirstDayCostCancellation()
//                //                                                                                          .getValue());
//                //
//                //                                                           //JOptionPane.showMessageDialog(null,"  Leer      ");
//                //
//                //                                                           /********** Antes de Politicas de Cancelacion *******************************/
//                //
//                //                                           }
//                //
//                //                           }
//                //
//                //                           /*********************************************************************/
//                //
//                //                           /*** Ver Detalle del PaymentAttemp **/
//                //
//                //                           ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
//                //                           RequestBookingDTO requestBookingDTO = new RequestBookingDTO();
//                //                           requestBookingDTO.setIdLiferay(portalIdPrueba);
//                //                           requestBookingDTO.setOriginCode("");
//                //                           requestBookingDTO.setDestinyCode(destinyCodePrueba); // Se esta Enviando  la Zona en el Request del
//                //                           requestBookingDTO.setOutOfCountry(false);
//                //                           requestBookingDTO.setReceiveEmailDeals(false);
//                //                           requestBookingDTO.setPortalCode(portalCodePrueba);
//                //
//                //                           Calendar departureCalendar = Calendar.getInstance();
//                //                           departureCalendar.set(anhoIniPrueba, mesIniPrueba, diaIniPrueba, 0, 0);
//                //                           long departureTime = departureCalendar.getTimeInMillis();
//                //                           Date departureDate = new Date(departureTime);
//                //                           requestBookingDTO.setDepartureDate(departureDate);
//                //
//                //                           Calendar returnCalendar = Calendar.getInstance();
//                //                           returnCalendar.set(anhoFinPrueba, mesFinPrueba, diaFinPrueba, 0, 0);
//                //                           long returnTime = returnCalendar.getTimeInMillis();
//                //                           Date returnDate = new Date(returnTime);
//                //
//                //                           requestBookingDTO.setReturnDate(returnDate);
//                //                           ContactPhoneDTO contactPhoneDTO = new ContactPhoneDTO();
//                //                           contactPhoneDTO.setIdContactPhoneType(PhoneType.CellPhone.getValue());
//                //                           contactPhoneDTO.setPhone("232421526");
//                //                           /********************** Datos del Pasajero ***************************************/
//                //
//                //                           ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
//                //                           // contactInformationDTO.setEmail("jigcornejo@falabella.cl");
//                //                           contactInformationDTO.setEmail("cadiz.v@gmail.com");
//                //                           contactInformationDTO.setPhones(new ArrayList<ContactInformationPhoneDTO>());
//                //
//                //                           ContactInformationPhoneDTO contactInformationPhoneDTO = new ContactInformationPhoneDTO();
//                //                           contactInformationPhoneDTO.setContactPhoneType(PhoneType.CellPhone.getValue());
//                //                           contactInformationPhoneDTO.setNumber("988478877");
//                //                           contactInformationDTO.getPhones().add(contactInformationPhoneDTO);
//                //                           requestBookingDTO.setContactPhoneDTO(contactPhoneDTO);
//                //                           requestBookingDTO.setContactInformation(contactInformationDTO);
//                //                           /*********************************************************************/
//                //
//                //                           PaymentAttemptDTO paymentAttemptDTO = new PaymentAttemptDTO();
//                //                           paymentAttemptDTO.setQuotas(1);
//                //                            paymentAttemptDTO.setQuotaValue(hotelFichaDTO.getHotelBookingRulesRSDTO().getResults().getListHotelResults()
//                //                                                           .get(0).getListHotelOptions().get(0).getPriceInformation().getPrices().get(0).getTotalFixAmountJP().getGross());
//                //                           paymentAttemptDTO.setPaymentAttemptType(1);
//                //                           /****************** AUTORIZACION ES DESPUES DE LA RESERVA **********************************/
//                //                           /****************** AUTORIZACION ES DESPUES DE LA RESERVA **********************************/
//                //                           paymentAttemptDTO.setNpsPaymentAttempts(new ArrayList<NPSPaymentAttemptDTO>());
//                //
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().add(0, new NPSPaymentAttemptDTO());
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setCommerceCode("dsds");
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdAirline(212);
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdCountry(1);
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdFlowType(2);
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdNPSBank(1);
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setIdNPSCard(1);
//                //                           paymentAttemptDTO.getNpsPaymentAttempts().get(0).setQuotas(2);
//                //                           requestBookingDTO.setPaymentAttempt(paymentAttemptDTO);
//                //                           // //USD DOLAR GRINGO
//                //                           requestBookingDTO.setProductPriceDTOs(new ArrayList<ProductPriceDTO>());
//                //                           requestBookingDTO.getProductPriceDTOs().add(0, new ProductPriceDTO());
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setChangeType(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setCommissionCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setCurrency("USD");
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setDiscountCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setFee(new BigDecimal(0));
//                //                            requestBookingDTO.getProductPriceDTOs().get(0).setFeeService(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setFinancingInterest(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setNetCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTax(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTaxAfip(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTotalCost(new BigDecimal(0));
//                //                           // //CLP PESO CHILENO
//                //                           requestBookingDTO.setProductPriceDTOs(new ArrayList<ProductPriceDTO>());
//                //                           requestBookingDTO.getProductPriceDTOs().add(0, new ProductPriceDTO());
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setChangeType(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setCommissionCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setCurrency(countryCurren);
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setDiscountCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setFee(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setFeeService(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setFinancingInterest(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setNetCost(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTax(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTaxAfip(new BigDecimal(0));
//                //                           requestBookingDTO.getProductPriceDTOs().get(0).setTotalCost(new BigDecimal(0));
//                //                           // //Offline //Datos de William Wallace. ver como los setea en el PASO 3
//                //
//                //                           //                           requestBookingDTO.getPaymentAttempt().setOffLines(new ArrayList<OffLineDTO>());
//                //                           //                           requestBookingDTO.getPaymentAttempt().getOffLines().add(new OffLineDTO());
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setAddress("");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setBirthDate(new Date());
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCardNumber("4051885600446623");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCardPassword("1234");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setCellPhone("+56 999887766");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setEmailAddress("julio.i.cornejo.g@gmail.com");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setExpirationMonth(1);
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setExpirationYear(2017);
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIdentifier("22.222.222-2");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIdIdentifierType(4);
//                //                           //
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setIssuingBank("AMB Amro");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setNameOFF("nameOFF");
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setNoResident(true);
//                //                           //                            requestBookingDTO.getPaymentAttempt().getOffLines().get(0).setPhone("344324324");
//                //
//                //                           // //HotelBookingDetailDTO
//                //                           // RATE PLAN CODE MANO.....
//                //
//                //                           requestBookingDTO.setRatePlanCode(hotelFichaDTO
//                //                                                           .getHotelBookingRulesRSDTO().getResults().getListHotelResults()
//                //                                                           .get(0).getListHotelOptions().get(0).getBookingCode()
//                //                                                           .getValue());
//                //                            /*******************************************************************************/
//                //
//                //                           requestBookingDTO.setHotelFichaDTO(hotelFichaDTO);
//                //                           // Passenger - Passenger - Passenger
//                //                           // El Primero de los Pasajeros va con Lider ==true.
//                //                           requestBookingDTO.setPassengerDTOs(new ArrayList<PassengerDTO>());
//                //                           /**********************************/
//                //                           requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setBirthDate(new Date());
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setGender("M");
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setIdentifier("11111111-1");
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setIdentifierType(4);
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setLastName("wallace");
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setLider(true);
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setNationality("CL");
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setName("william");
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setPassengerAddress("Amunategui 695");
//                //
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setPassengerType(1);
//                //                           requestBookingDTO.getPassengerDTOs().get(0).setAge(30);
//                //                           /**********************************/
//                //                           //                           requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setBirthDate(new Date());
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setGender("M");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setIdentifier("22222222-2");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setIdentifierType(4);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setLastName("wallace");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setLider(false);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setNationality("CL");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setName("wally west");
//                //                           //                            requestBookingDTO.getPassengerDTOs().get(1).setPassengerAddress("Amunategui 695");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setPassengerType(1);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(1).setAge(30);
//                //                           /***************************************************/
//                //                           /*requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setBirthDate(new Date());
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setGender("M");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setIdentifier("33333333-3");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setIdentifierType(4);
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setLastName("wallace");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setLider(false);
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setNationality("CL");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setName("waldorfino");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setPassengerAddress("Amunategui 695");
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setPassengerType(2);
//                //                           requestBookingDTO.getPassengerDTOs().get(1).setAge(edadNinho1Pieza1);*/
//                //                           /**************************************************************/
//                //                           //                           requestBookingDTO.getPassengerDTOs().add(new PassengerDTO());
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setBirthDate(new Date());
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setGender("M");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setIdentifier("44444444-4");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setIdentifierType(4);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setLastName("wallace el adoptado");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setLider(false);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setNationality("CL");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setName("walinho scratch");
//                //                           //                            requestBookingDTO.getPassengerDTOs().get(3).setPassengerAddress("Amunategui 695");
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setPassengerType(2);
//                //                           //                           requestBookingDTO.getPassengerDTOs().get(3).setAge(edadNinho2Pieza1);
//                //                           //                           /**********************************/
//                //                           // Retornar el Producto
//                //                           WrapperProductoDto reservaHoteles = clientProducto.reservarHotel(requestBookingDTO);
//                //                           return reservaHoteles.getProductoDTO();
//                //                           // Retorna un IdQuote o algo por el Estilo
//                //                           // Ir a ver a la Base de Datos
//                //            }
//
//                /****************** PASO 3 compra-hoteles *****************/
//                /****************** PAGO 4 *****************/
//                /***************** Metodo de Austin **********************/
//                //            public ProductoDTO buscarCotizacionCompra(int idQuote) {
//                //
//                //                           System.out.println("..PASO 4 Obtener la Cotizacion..");
//                //                           ClientProducto_ObtenerCompra clientProducto_ObtenerCompra = new ClientProducto_ObtenerCompra();
//                //                           ProductoDTO productoDTO = new ProductoDTO();
//
//                //                           RequestSearchDTO requestSearchDTO = new RequestSearchDTO();
//                //                           QuoteDTO quoteDTO = new QuoteDTO();
//                //                           quoteDTO.setIdQuote(idQuote);
//                //                           requestSearchDTO.setQuoteDTO(quoteDTO);
//                //                           productoDTO = clientProducto_ObtenerCompra.buscarCotizacionCompra(requestSearchDTO);
//                //                           CotizacionDTO objCotizacionDTO = productoDTO.getCotizacionDTO();
//                //                           objCotizacionDTO.getObjHotelOptionDTO();
//                //                           return productoDTO;
//                //
//                //            }
//                //            /***************** Metodo de Austin **********************/
//                //            /***************** Metodo de Recu **********************/
//                //
//                //            public ProductoDTO confirmar(int idQuote) {
//                //
//                //                           System.out.println("..PASO 4 Confirmar..");
//                //                           ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
//                //                           RequestConfirmDTO objRequestConfirm = new RequestConfirmDTO();
//                //                           objRequestConfirm.setIdLiferay(portalIdPrueba);
//                //                           objRequestConfirm.setIdNegocio(idQuote);
//                //                           objRequestConfirm.setPortalCode(portalCodePrueba);
//                //                           QuoteDTO cuota = new QuoteDTO();
//                //                           cuota.setIdQuote(idQuote);
//                //
//                //                           ProductoDTO productoDTO = clientProducto.confirmarHotel(objRequestConfirm);
//                //                           System.out.println(productoDTO);
//                //
//                //                           return productoDTO;
//                //                           //                           return null;
//                //
//                //            }
//                //
//                //                /********************************************************************************************/
//                //
//                //            public ProductoDTO test_enviarMail(int idQuote) {
//                //                           ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
//                //                           RequestSearchDTO requestSearchDTO = new RequestSearchDTO();
//                //
//                //                           QuoteDTO quoteDTO = new QuoteDTO();
//                //                           quoteDTO.setIdQuote(idQuote);
//                //                           requestSearchDTO.setQuoteDTO(quoteDTO);
//                //                           WrapperProductoDto wrp = clientProducto.enviarEmail(requestSearchDTO);
//                //
//                //                           return wrp.getProductoDTO();
//                //            }
//                //
//                //
//                //
//                //            public static String redondeoCancellationPolicies(String politica) {
//                //                           // Si viene en USD no se hace nada
//                //
//                //                           Pattern pat = Pattern.compile(".*USD.*");
//                //                           Matcher mat = pat.matcher(politica);
//                //
//                //                           if (!mat.matches()) {
//                //
//                //                                           String politica2 = politica.replaceFirst(",[0-9][0-9]", "");
//                //                                           if (politica2.equals(politica)) {
//                //                                                           politica2 = politica.replaceFirst(",[0-9]", "");
//                //                                           }
//                //
//                //                                           if (!politica2.equals(politica)) {
//                //
//                //                                                           String[] politica3 = politica2.split(" ");
//                //                                                           String monto = "";
//                //                                                           String monto3 = "";
//                //
//                //                                                           for (int i = 0; i < politica3.length; i++) {
//                //                                                                          if (politica3[i].equals("CLP")
//                //                                                                                                          || politica3[i].equals("ARS")
//                //                                                                                                          || politica3[i].equals("COP")
//                //                                                                                                          || politica3[i].equals("PEN")) {
//                //
//                //                                                                                          monto = politica3[i - 1];
//                //
//                //                                                                          }
//                //
//                //                                                           }
//                //
//                //                                                           Integer monto2 = Integer.valueOf(monto);
//                //                                                           monto2++;
//                //                                                           monto3 = monto2.toString();
//                //
//                //                                                           politica2 = politica2.replace(" " + monto + " ", " " + monto3
//                //                                                                                          + " ");
//                //
//                //                                           }
//                //                                           return politica2;
//                //                           }
//                //                           return politica;
//                //            }
//
//                /********************************************************************************************/
////                /********************************************************************************************/
////                /********************************************************************************************/
////                public void ejecutarPortal() {
////                               ClientMantenedor_Portal clientProducto = new ClientMantenedor_Portal();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               BusquedaDTO busquedaDTO = utilidadesMostrarTest.generarBusquedaPortal();
////                               PortalDTO metPortalDTO=new PortalDTO();
////
////                               metPortalDTO.setIdPortalLiferay(busquedaDTO.getPortalCode()); //17736 QA de verdad
////                               metPortalDTO = clientProducto.clientePortalByCode(metPortalDTO);
////                               System.out.println("Prueba en Portal "+metPortalDTO.getDescription());
////
////
////                }
////
////                public ZoneDTO buscarZonaBusqueda() {
////                               ClientProducto_FlujoHotel clientProducto = new ClientProducto_FlujoHotel();
////                               UtilidadesPoderSupremo utilidadesMostrarTest = new UtilidadesPoderSupremo();
////                               RequestProductoDTO requestHijoDTO = new RequestProductoDTO();
////                               BusquedaDTO busquedaDTO = new BusquedaDTO();
////
////                               busquedaDTO = utilidadesMostrarTest.generarBusqueda();
////                               busquedaDTO = utilidadesMostrarTest.eliminarDatosListaRoomDTO(busquedaDTO); //Eliminar los Datos d compra innecesarios a este nivel
////
////                               requestHijoDTO.setBusquedaDTO(busquedaDTO);
////                               ZoneDTO metZoneDTO= clientProducto.buscarDetalleBusquedaHotel(requestHijoDTO);
////                               System.out.println("Prueba en Zona "+metZoneDTO.getStrName()+" - "+metZoneDTO.getStrZoneCode());
////                               return metZoneDTO;
////
////                }
////
////                /********************************************************************************************/
////                /********************************************************************************************/
////                /********************************************************************************************/
////                /**
////                * select q.idQuote,q.contactMail, s.idService,hq.dateTime, q.registerDate,ss.modifyDate, ss.idStatusServiceType from dev.HistoryQuote hq
////                inner join dev.Quote q on hq.idQuote = q.idQuote
////                inner join dev.Service s on q.idQuote = s.idQuote
////                inner join dev.StatusService ss on s.idService = ss.idService
////                where ss.idStatusServiceType =2 order by q.idQuote desc limit 5;
////                */
////                //            @Test
////                //            public void only_enviarMail() {
////                //                           ClientProducto_Hotel clientProducto = new ClientProducto_Hotel();
////                //                           RequestSearchDTO requestSearchDTO = new RequestSearchDTO();
////                //                           
////                //                           QuoteDTO quoteDTO = new QuoteDTO();
////                ////                       quoteDTO.setIdQuote(201159);
////                ////                       quoteDTO.setIdQuote(5001917); //Peru QA
////                ////                       quoteDTO.setIdQuote(101030); //Peru
////                //                           quoteDTO.setIdQuote(100737);
////                //                           requestSearchDTO.setQuoteDTO(quoteDTO);
////                //                           WrapperProductoDto wrp = clientProducto.enviarEmail(requestSearchDTO);
////                ////                       
////                //                           quoteDTO.setIdQuote(101030);
////                //                           requestSearchDTO.setQuoteDTO(quoteDTO);
////                //                           wrp = clientProducto.enviarEmail(requestSearchDTO);
////                //                           
////                //                           System.out.println("Fin");
////                //            }
////
////                //            @Test
////                //            public void only_buscarCotizacionCompra() {
////                //
////                //                           System.out.println("..PASO 4 Obtener la Cotizacion..");
////                //                           ClientProducto_ObtenerCompra clientProducto_ObtenerCompra = new ClientProducto_ObtenerCompra();
////                //                           ProductoDTO productoDTO = new ProductoDTO();
//
////                //                           RequestSearchDTO requestSearchDTO = new RequestSearchDTO();
////                //                           QuoteDTO quoteDTO = new QuoteDTO();
////                //                           quoteDTO.setIdQuote(201824);
////                //                            requestSearchDTO.setQuoteDTO(quoteDTO);
////                //                           productoDTO = clientProducto_ObtenerCompra.buscarCotizacionCompra(requestSearchDTO);
////                //                           CotizacionDTO objCotizacionDTO = productoDTO.getCotizacionDTO();
////                //                           
////                //                           System.out.println(objCotizacionDTO);
////                //                           
////                //            }
////
////                /********************************************************************************************/
////                public void recorrerSearchHoteles(ProductoDTO prodLstHoteles){
////
////                               List<HotelResultJPDTO> listaHotelResultJPDTO = new  ArrayList<HotelResultJPDTO>(); 
////                               listaHotelResultJPDTO = prodLstHoteles.getLstHotel();
////                               /*************************************************/
////                               for(int tt=0;tt<listaHotelResultJPDTO.size();tt++){
////                                               System.out.println("----------------------------------------------------------------------------");
////                                               System.out.println(listaHotelResultJPDTO.get(tt).getHotelInfoJP().getName());
////                                               for(int uu=0;uu<listaHotelResultJPDTO.get(tt).getListHotelOptionJPs().size();uu++){
////                                                               if(listaHotelResultJPDTO.get(tt).getListHotelOptionJPs().get(uu).getListHotelOffers()!=null){
////                                                                              for(int vv=0;vv<listaHotelResultJPDTO.get(tt).getListHotelOptionJPs().get(uu).getListHotelOffers().size();vv++){
////                                                                                              if(!listaHotelResultJPDTO.get(tt).getListHotelOptionJPs().get(uu).getListHotelOffers().get(vv).getDescription().equals("")){
////                                                                                                              System.out.println("-----"+listaHotelResultJPDTO.get(tt).getListHotelOptionJPs().get(uu).getListHotelOffers().get(vv).getDescription());
////                                                                                              }
////                                                                              }
////                                                               }else{
////                                                                              System.out.println("No existen promociones/ofertas asociadas a esta Opcion de Hotel");
////                                                               }
////
////                                               }
////                                               System.out.println("----------------------------------------------------------------------------");
////                               }
////                               /*************************************************/
////                }
////
////                //public int getInstanteBusqueda() {
////                //            return instanteBusqueda;
////                //}
////                //
////                //public void setInstanteBusqueda(int instanteBusqueda) {
////                //            this.instanteBusqueda = instanteBusqueda;
////                //}
//
//
////}
