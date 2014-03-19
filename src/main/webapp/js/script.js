function initialize() {
	var mapProp = {
		center:new google.maps.LatLng(-22.413979,-45.45037),
		zoom:15,
		scrollwheel: false,
        streetViewControl: true,
        labels: true,
		mapTypeId:google.maps.MapTypeId.ROADMAP
	};
	var map=new google.maps.Map(document.getElementById("mapItajuba"),mapProp);

	var marker=new google.maps.Marker({
		position:mapProp.center
	});
	marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);