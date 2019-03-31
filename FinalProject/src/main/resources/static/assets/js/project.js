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

	initCharts: function(listLabel,listTotalLikes,listTotalShares) {
	    if ($('#multipleBarsChart').length != 0) {
	
	
	    	 var dataMultipleBarsChart = {
	                 labels: listLabel,
	                 series: [
	                	 listTotalLikes,
	                	 listTotalShares
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
