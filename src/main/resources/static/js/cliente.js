"use strict";
(function ($) {
    var app = {
        init: function () {
            this.variables();
            this.plantillas();
            this.elementos();
            this.acciones();
        },
        variables: function () {
            this.tabla;
            this.clickedRow;
            this.cantidadTareasEmpleado;
        },
        elementos: function () {

            this.$tablaResultado = $("#tabla-resultado");

            //Modal Nuevo Cliente
            this.$btnModalNuevo = $("#btn-modal-nuevo");
            this.$modalNuevoCliente = $("#modalNuevoCliente");
            this.$btnCrearCliente = $("#btnCrearCliente");

            //Inputs Nuevo Empleado
            this.$iptNombre = $("#ipt-nombre");
            this.$iptDni = $("#ipt-dni");
            this.$iptTelefono = $("#ipt-telefono");
            this.$iptDireccion = $("#ipt-direccion");


            //Modal Modificar Cliente
            this.$modalModificarCliente = $("#modalModificarCliente");
            this.$btnModificarCliente = $("#btnModificarCliente");
            
            //Inputs Modificacion Cliente
            this.$iptMdfId = $("#ipt-mdf-id");
            this.$iptMdfNombre = $("#ipt-mdf-nombre");
            this.$iptMdfDni = $("#ipt-mdf-dni");
            this.$iptMdfTelefono = $("#ipt-mdf-telefono");
            this.$iptMdfDireccion = $("#ipt-mdf-direccion");
        },
        plantillas: function () {

        },
        funciones: {

            /**
             * Muestra/Oculta LoadingOverlay 
             */
            cargando: function (mostrar) {

                if (mostrar)
                    $.LoadingOverlay('show', {image: "", fontawesome: "fa fa-spinner fa-pulse"});
                else
                    $.LoadingOverlay('hide', true);
            },

            obtenerCliente: function () {
                return {
                    nombreCliente: app.$iptNombre.val(),
                    dni: app.$iptDni.val(),
                    telefono: app.$iptTelefono,
                    direccion: app.$iptDireccion.val()
                };
            },

            obtenerClienteModificar: function () {
                return {
                    idCliente: app.$iptMdfId.val(),
                    nombreCliente: app.$iptMdfNombre.val(),
                    dni: app.$iptMdfDni.val(),
                    telefono: app.$iptMdfTelefono.val(),
                    direccion: app.$iptMdfDireccion.val()
                };
            },

            validarFormClienteCrear: function () {
                var errores = [];

                if ($.trim(app.$iptNombre.val()) == '')
                    errores.push("El nombre es obligatorio.");
                if (app.funciones.validarNumeroCadena(app.$iptNombre.val()))
                    errores.push("El nombre no puede tener numeros.");
                if (app.funciones.validarNumeroTelefono(app.$iptTelefono.val()))
                    errores.push("El telefono no puede tener letras.");

                return errores;

            },

            validarFormClienteModificar: function () {
                var errores = [];

                if ($.trim(app.$iptMdfNombre.val()) == '')
                    errores.push("El nombre es obligatorio.");
                if (app.funciones.validarNumeroCadena(app.$iptMdfNombre.val()))
                    errores.push("El nombre no puede tener numeros.");
                if (app.funciones.validarNumeroTelefono(app.$iptMdfTelefono.val()))
                    errores.push("El telefono no puede tener letras.");

                return errores;

            },

            validarNumeroCadena: function (texto) {
                var numeros = '0123456789';
                for (var i = 0; i < texto.length; i++) {
                    if (numeros.indexOf(texto.charAt(i), 0) != -1) {
                        return true;
                    }
                }
                return false;
            },
            validarNumeroTelefono: function (texto) {
                var numeros = '0123456789';
                for (var i = 0; i < texto.length; i++) {
                    if (numeros.indexOf(texto.charAt(i), 0) != -1) {
                        return false;
                    }
                }
                return true;
            },
            validarFechasRango: function (fecha) {
                var fechaActual = new Date();
                var fechaComparar = new Date(app.funciones.convertirFechaString(fecha));

                var fechaActualString = fechaActual.getDate() + "/" + (fechaActual.getMonth() + 1) + "/" + fechaActual.getFullYear();
                var fechaCompararString = fechaComparar.getDate() + "/" + (fechaComparar.getMonth() + 1) + "/" + fechaComparar.getFullYear();

                fechaActual = new Date(app.funciones.convertirFechaString(fechaActualString));
                fechaComparar = new Date(app.funciones.convertirFechaString(fechaCompararString));

                if (fechaComparar.getTime() <= fechaActual.getTime()) {
                    return true;
                }
                return false;
            },

            borrarCliente: function (data, row) {

                app.funciones.cargando(true);

                //	recogemos la linea del documento
                var id = data.id;

                //	Borramos el documento
                //	Recogemos los valores por JSON de los metadatos a enseñar
                $.ajax({
                    type: "DELETE",
                    url: "cliente/" + id,
                }).done(function (response) {

                    if (response.success === true) {
                        swal('Operaci\u00F3n exitosa!', 'Se ha borrado el empleado', 'success');
                        row.remove().draw();
                    } else {
                        var errorMsg = response.errorCode != null ? response.message : 'Se present\u00F3 un error al borrar el empleado, contacte al administrador.';
                        swal('Error!', errorMsg, 'error');
                    }

                }).fail(function (error) {
                    swal('Error!', 'Ocurrio un error al borrar el cliente, contacte con el Administrador.', 'error');
                }).always(function () {
                    app.funciones.cargando(false);
                });

            },

            convertirFechaString: function (fechaConvertir) {
                var dateParts = fechaConvertir.split("/");
                var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
                return new Date(dateObject).toISOString();
            },

            cargarDatosCliente: function (data) {
                app.$iptMdfId.val(data.idCliente);
                app.$iptMdfDni.val(data.dni);
                app.$iptMdfNombre.val(data.nombreCliente);
                app.$iptMdfTelefono.val(data.telefono);
                app.$iptMdfDireccion.val(data.direccion);
            }

        },
        acciones: function () {

//            app.$iptFechaIngreso.datetimepicker({format: 'dd/mm/yyyy', minView: 2, autoclose: true});
//            app.$iptMdfFechaIngreso.datetimepicker({format: 'dd/mm/yyyy', minView: 2, autoclose: true});

            /**
             * -Funcionalidad: Inicializa DataTable
             * #Inicializa el plugin de manejo de tablas
             */
            this.tabla = this.$tablaResultado.DataTable({
                dom: "<'row'<'col-md-4 float-left'l><'col-md-4'i><'col-md-4 float-right'f>><>t<'row justify-content-center'<p>>",
                processing: true,
                scrollX: true,
                scrollCollapse: true,
                searching: true,
                autoWidth: true,
                paging: true,
                info: true,
                responsive: true,
                order: [[1, null]],
                ajax: {
                    url: "cliente/todos",
                    dataSrc: "",
                    type: "GET",
                    contentType: "application/json",
                },
                columns: [
                    {
                        title: 'C.C.',
                        data: 'dni',
                       
                    },
                    {
                        title: 'Nombre',
                        data: 'nombreCliente'
                    },
                    {
                        title: 'Telefono',
                        data: 'telefono',
                        render:function(data,type,row,meta){
                            return (row.telefono != null ? row.telefono : '');
                        },
                    },
                    {
                        title: 'Direccion',
                        data: 'direccion',
                        render:function(data,type,row,meta){
                            return (row.direccion != null ? row.direccion : '');
                        },
                    },
                    {
                        title: 'Acciones',
                        data: 'acciones',
                        render: function (data, type, row, meta) {

                            return '<div class="btn-group">' +
                                    '<i class="edicion action-float-icon fas fa-pen waves-effect waves-circle waves-float waves-light bg-primary text-white" aria-hidden="true" title="Modificar" data-toggle="modal" data-target="#modalModificarCliente"></i>' +
                                    '<i class="borrado action-float-icon fa fa-trash waves-effect waves-circle waves-float waves-light bg-danger text-white" aria-hidden="true" title="Eliminar"></i>' +
                                    '</div>';
                        },
                        orderable: false,
                        searchable: false
                    },
                ],
                language: {
                    search: "Filtrar",
                    lengthMenu: "Ver _MENU_ entradas",
                    info: "Mostrando _START_ a _END_ de _TOTAL_ entradas",
                    infoEmpty: "Mostrando _START_ a _END_ de _TOTAL_ entradas",
                    emptyTable: "No hay datos disponibles",
                    zeroRecords: "No hay datos disponibles",
                    infoFiltered: "(filtrado de un total de _MAX_ registros)",
                    paginate: {
                        first: "Inicio",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Fin"
                    }
                }
            });

            /********************Eventos************************/
            /**
             * #Inicializa el evento click sobre las filas de la tabla
             */
            this.tabla.on('draw', function () {


                app.$tablaResultado.find("tbody").on("click", ".action-float-icon", function () {

                    var $this = $(this);
                    var $trParent = $this.parents('tr');
                    app.clickedRow = $trParent.hasClass("child") ? $trParent.prev() : $trParent;
                    var row = app.tabla.row(app.clickedRow);
                    var dataRow = row.data();

                    if ($this.hasClass("edicion")) {

                        app.funciones.cargarDatosCliente(dataRow);
                        app.$modalModificarCliente.modal("show");
                    } else if ($this.hasClass("borrado")) {
                        swal({
                            title: 'Confirmaci\u00F3n',
                            text: "\u00BFDesea borrar el Cliente?",
                            type: 'question',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'Si, borrarlo!',
                            cancelButtonText: 'Cancelar'
                        }).then(function (result) {
                            if (result.value) {
                                app.funciones.borrarCliente(dataRow, row);
                            }
                        });
                    }

                });
            });

            this.$btnCrearCliente.click(function () {

                var errores = app.funciones.validarFormClienteCrear();

                if (errores.length > 0) {
                    swal('Error!', errores.join("<br>"), 'error');
                    return;
                }

                app.funciones.cargando(true);

                $.ajax({
                    type: "POST",
                    url: "cliente",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(app.funciones.obtenerCliente())
                }).done(function (response) {
                    if (response.success === true) {
                        swal('Operaci\u00F3n exitosa!', 'Empleado creado correctamente', 'success');
                        app.$modalNuevoCliente.modal('hide');
                        app.tabla.row.add(response.data).draw();
                    } else {
                        var errorMsg = response.errorCode != null ? response.message : 'Se present\u00F3 un error al crear el empleado, contacte al administrador.';
                        swal('Error!', errorMsg, 'error');
                    }

                }).fail(function (error) {
                    swal('Error!', 'Ocurrio un error al crear el empleado, contacte con el Administrador.', 'error');
                }).always(function () {
                    app.funciones.cargando(false);
                });

            });

            this.$btnModificarCliente.click(function () {

                var errores = app.funciones.validarFormClienteModificar();

                if (errores.length > 0) {
                    swal('Error!', errores.join("<br>"), 'error');
                    return;
                }

                app.funciones.cargando(true);
                var fila = app.tabla.row(app.clickedRow);

                $.ajax({
                    type: "PUT",
                    url: "cliente",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(app.funciones.obtenerClienteModificar())
                }).done(function (response) {

                    if (response.success === true) {
                        swal('Operaci\u00F3n exitosa!', 'Cliente modificado correctamente', 'success');
                        app.$modalModificarCliente.modal('hide');
                        fila.remove().draw();
                        app.tabla.row.add(response.data).draw();
                    } else {
                        var errorMsg = response.errorCode != null ? response.message : 'Se present\u00F3 un error al modificar el Cliente, contacte al administrador.';
                        swal('Error!', errorMsg, 'error');
                    }

                }).fail(function (error) {
                    swal('Error!', 'Ocurrio un error al modificar el Cliente, contacte con el Administrador.', 'error');
                }).always(function () {
                    app.funciones.cargando(false);
                });

            });

            this.$modalNuevoCliente.on('hidden.bs.modal', function () {
                app.$iptNombre.val('');
                app.$iptDni.val('');
                app.$iptTelefono.val('');
                app.$iptDireccion.val('');
            });
        }
    }
    return {
        init: app.init(),
    }
})(jQuery)
