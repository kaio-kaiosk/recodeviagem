function validar() {
	let nomeCliente = frmCliente.nomeCliente.value
	let telefone = frmCliente.telefone.value
	
	if (nomeCliente === "") {
		alert('O nome do cliente não pode ser vazio')
		frmCliente.nomeCliente.focus()
		return false
	} else if (telefone==="") {
		alert('O telefone do cliente não pode ser vazio')
		frmCliente.telefone.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
} 