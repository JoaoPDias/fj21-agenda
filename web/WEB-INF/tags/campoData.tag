<%@ attribute name="id" required="true" %>
<input type="text" id="${id}" name="${id}" value ="${requestScope.datanasc}" />
<script type="text/javascript">
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy',
                            changeMonth: true, 
                            changeYear: true,
                            dayNames: ["Domingo", "Segunda-Feira", "Ter�a-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "S�bado"],
                            dayNamesMin: [ "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "S�b" ],
                            minDate: new Date(1900,1-1,1),
                            monthNames: ["Janeiro","Fevereiro","Mar�o","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                            monthNamesShort: ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],
                            showAnim: "clip",
                            showButtonPanel: true
    });

</script>