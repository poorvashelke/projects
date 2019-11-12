<?php
$latitude = 37.7678524427122;
$longitude = 122.466104892532;
  
$url = "http://maps.googleapis.com/maps/api/geocode/json?address='.$formattedAddr.'&sensor=true_or_false&key=GoogleAPIKey";
  
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$responseJson = curl_exec($ch);
curl_close($ch);
  
$response = json_decode($responseJson);
  
if ($response->status == 'OK') {
    echo $address = $response->results[0]->formatted_address;
} else {
    echo $response->status;
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred."
            break;
    }
}

function getData() {
	$.ajax({
	    url: "https://data.sfgov.org/resource/6a9r-agq8.json",
	    type: "GET",
	    data: {
	      "$limit" : 5000,
	      "$$app_token" : "GgWNAcFmnDbmOH66vLqsmycxg"
	    }
	}).done(function(data) {
	  //alert("Retrieved " + data.length + " records from the dataset!");
	  //console.log(data);
	  
	  $.each(data, function(key,value){				 
		  if((latitude + 0.3) < value.latitude
				  || (latitude - 0.3) > value.latitude					 
				  || (longitude + 0.3) < value.longitude
				  || (longitude - 0.3) > value.longitude) {
			  return;}
		  var truckCenter = new google.maps.LatLng(value.latitude, value.longitude);
		  var marker = new google.maps.Marker({position:truckCenter});
		 /* var marker = new google.maps.Marker({
			  position: truckCenter,
			  icon: 1
			  //icon: "pinkball.png"
				  });*/
		  marker.setMap(map);
		  });	  
	  });
}

function showTrucksOnMap(position) {
	 //latitude = position.coords.latitude;
	 //longitude = position.coords.longitude;
	 
	 var mapOptions = {
	    center: new google.maps.LatLng(latitude, longitude),
	    zoom:14,
	    //bounds: googleMap.getBounds(),
	    type: 'Food truck',
	    mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	  
	  var userCenter = new google.maps.LatLng(latitude, longitude);
	  var marker = new google.maps.Marker({position:userCenter, animation: google.maps.Animation.BOUNCE});	  
	  map = new google.maps.Map(document.getElementById("googleMap"),mapOptions);
	  marker.setMap(map);
	  
	  getData();
}

function getLatLong($address){
    if(!empty($address)){
    	$geocodeFromAddr = file_get_contents('http://maps.googleapis.com/maps/api/geocode/json?address='.$formattedAddr.'&sensor=true_or_false&key=GoogleAPIKey');
        //Formatted address
        $formattedAddr = str_replace(' ','+',$address);
        //Send request and receive json data by address
        $geocodeFromAddr = file_get_contents('http://maps.googleapis.com/maps/api/geocode/json?address='.$formattedAddr.'&sensor=false'); 
        $output = json_decode($geocodeFromAddr);
        //Get latitude and longitute from json data
        $data['latitude']  = $output->results[0]->geometry->location->lat; 
        $data['longitude'] = $output->results[0]->geometry->location->lng;
        //Return latitude and longitude of the given address
        if(!empty($data)){
            return $data;
        }else{
            return false;
        }
    }else{
        return false;   
    }
}