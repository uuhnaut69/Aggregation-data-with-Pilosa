project = {
    showSwal: function(type) {
	    if (type == 'warning-message-and-confirmation') {
	        swal({
	            title: 'Are you sure?',
	            text: "The operation will take time to complete.",
	            type: 'warning',
	            showCancelButton: true,
	            confirmButtonClass: 'btn btn-success',
	            cancelButtonClass: 'btn btn-danger',
	            confirmButtonText: 'Okay!',
	            buttonsStyling: false
	        }).then(function() {
	            swal({
	                title: 'Done!',
	                text: 'BenchMark Completed',
	                type: 'success',
	                confirmButtonClass: "btn btn-success",
	                buttonsStyling: false
	            })
	        }).catch(swal.noop)
	    }
	},

	initCharts: function() {
	    if ($('#multipleBarsChart').length != 0) {
	
	
	        var dataMultipleBarsChart = {
	            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
	            series: [
	                [542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895],
	                [412, 243, 280, 580, 453, 353, 300, 364, 368, 410, 636, 695]
	            ]
	        };
	
	        var optionsMultipleBarsChart = {
	            seriesBarDistance: 10,
	            axisX: {
	                showGrid: false
	            },
	            height: '300px'
	        };
	
	        var responsiveOptionsMultipleBarsChart = [
	            ['screen and (max-width: 640px)', {
	                seriesBarDistance: 5,
	                axisX: {
	                    labelInterpolationFnc: function(value) {
	                        return value[0];
	                    }
	                }
	            }]
	        ];
	
	        var multipleBarsChart = Chartist.Bar('#multipleBarsChart', dataMultipleBarsChart, optionsMultipleBarsChart, responsiveOptionsMultipleBarsChart);
	
	        // start animation for the Emails Subscription Chart
	        md.startAnimationForBarChart(multipleBarsChart);
	    }
	
	},

}
