function clickGuestRegister()
{
	document.getElementById('idEventGuestInsert').innerHTML = document.getElementById('eventIdEvent').innerHTML;
}

function clickGuestEdit()
{
	var $rowEdit = $(this).closest("tr"),
	$tdNameGuestEdit = $rowEdit.find("td:eq(0)");
	document.getElementById('nameGuestEdit').value = $tdNameGuestEdit.text();
	$tdCpfGuestEdit = $rowEdit.find("td:eq(1)");
	document.getElementById('cpfGuestEdit').value = $tdCpfGuestEdit.text();
	$tdIdStatusInviteEdit = $rowEdit.find("td:eq(2)");
	var $tdIdStatusInviteEditValue =  $tdIdStatusInviteEdit.text();
	for (var i=0; i <document.getElementById('statusInviteEdit').length; i++)
	{
		var $statusInviteOption = document.getElementById('statusInviteEdit')[i].value;
		if($statusInviteOption == $tdIdStatusInviteEditValue)
		{
			document.getElementById('statusInviteEdit').selectedIndex  = i;
		}
	}
	$tdIdEventGuestEdit = $rowEdit.find("td:eq(3)");
	document.getElementById('idEventGuestEdit').innerHTML = $tdIdEventGuestEdit.text();
}

function clickGuestDelete()
{
	var $rowDelete = $(this).closest("tr"),
	$tdNameGuestDelete = $rowDelete.find("td:eq(0)");
	document.getElementById('nameGuestDelete').innerHTML = $tdNameGuestDelete.text();
	$tdCpfGuestDelete = $rowDelete.find("td:eq(1)");
	document.getElementById('cpfGuestDelete').innerHTML = $tdCpfGuestDelete.text();
	$tdIdEventDelete = $rowDelete.find("td:eq(3)");
	document.getElementById('idEventGuestDelete').innerHTML = $tdIdEventDelete.text();
}

function changeGuestRegisterHref($nameGuestRegister, $cpfGuestRegister, $idEventRegister, $idStatusInviteRegister)
{
	document.getElementById('registerGuestSubmit').href = "/register/guest/"+$nameGuestRegister+"/"+$cpfGuestRegister+"/"+$idEventRegister+"/"+$idStatusInviteRegister;
}

function changeGuestEditHref($nameGuestEdit, $cpfGuestEdit, $idEventEdit, $idStatusInviteEdit)
{
	document.getElementById('editGuestSubmit').href = "/edit/guest/"+$nameGuestEdit+"/"+$cpfGuestEdit+"/"+$idEventEdit+"/"+$idStatusInviteEdit;
}

function changeGuestDeleteHref($cpfGuestDelete, $idEventDelete)
{
	document.getElementById('deleteGuestSubmit').href = "/delete/guest/"+$cpfGuestDelete+"/"+$idEventDelete;
}