function clickEventDelete()
{
	var $idDelete = document.getElementById('eventDelete');
	var $rowDelete = $idDelete.closest("tr"),
	$tdNameEventDelete = $($rowDelete).find("td:eq(0)").clone();
	document.getElementById('nameEventDelete').innerHTML = $tdNameEventDelete.text();
	$tdPlaceEventDelete = $($rowDelete).find("td:eq(1)");
	document.getElementById('placeEventDelete').innerHTML = $tdPlaceEventDelete.text();
	$tdDateEventDelete = $($rowDelete).find("td:eq(2)");
	document.getElementById('dateEventDelete').innerHTML = $tdDateEventDelete.text();
	$tdTimeEventDelete = $($rowDelete).find("td:eq(3)");
	document.getElementById('timeEventDelete').innerHTML = $tdTimeEventDelete.text();
	$tdIdEventDelete = $($rowDelete).find("td:eq(4)");
	document.getElementById('idEventDelete').innerHTML = $tdIdEventDelete.text();
}

function changeEventEditHref($nameEventEdit, $placeEventEdit,$dateEventEdit, $timeEventEdit, $idEventEdit)
{
	document.getElementById('editEventSubmit').href = "/edit/event/"+$nameEventEdit+"/"+$placeEventEdit+"/"+$dateEventEdit+"/"+$timeEventEdit+"/" + $idEventEdit;
}

function changeEventDeleteHref($idEventDelete)
{
	document.getElementById('deleteEventSubmit').href = "/delete/event/"+$idEventDelete;
}