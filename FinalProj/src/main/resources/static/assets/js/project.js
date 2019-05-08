project = {
    showSwal: function(type, queryParam) {
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

	// function Init Chart
	initCharts: function(id,listLabel,listTotalLikes,listTotalShares) {
	    if ($('#'+ id).length != 0) {
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
             var multipleBarsChart = Chartist.Bar('#'+ id, dataMultipleBarsChart, optionsMultipleBarsChart, responsiveOptionsMultipleBarsChart);
             // start animation for the Emails Subscription Chart
             md.startAnimationForBarChart(multipleBarsChart);
	    }
	
	},
	
	// Notification
	showNotification: function(from, align) {
        $.notify({
            icon: "notifications",
            message: "The operation successfully completed"

        }, {
            type: 'success',
            timer: 1000,
            placement: {
                from: from,
                align: align
            }
        });
    },

    checkFullPageBackgroundImage: function() {
        $page = $('.full-page');
        image_src = $page.data('image');

        if (image_src !== undefined) {
            image_container = '<div class="full-page-background" style="background-image: url(' + image_src + ') "/>'
            $page.append(image_container);
        }
    },

}
