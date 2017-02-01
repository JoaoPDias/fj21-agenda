<%@ attribute name="id" required="true" %>
<input type="text" id="${id}" name="${id}" value ="${requestScope.datanasc}" />
<script type="text/javascript">
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy',
                            changeMonth: true, 
                            changeYear: true,
                            dayNames: ["Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"],
                            dayNamesMin: [ "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb" ],
                            minDate: new Date(1900,1-1,1),
                            monthNames: ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                            monthNamesShort: ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],
                            showAnim: "clip",
                            showButtonPanel: true
    });

</script>