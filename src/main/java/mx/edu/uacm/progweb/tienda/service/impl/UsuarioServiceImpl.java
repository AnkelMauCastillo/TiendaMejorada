package mx.edu.uacm.progweb.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.dominio.Usuario;
import mx.edu.uacm.progweb.tienda.repository.UsuarioRepository;
import mx.edu.uacm.progweb.tienda.service.UsuarioService;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * {@link mx.edu.uacm.progweb.tienda.service.UsuarioService#obtenerUsuarioPorCorreoYContrasenia(String, String)}
	 */
	@Override
	public Usuario obtenerUsuarioPorCorreoYContrasenia(String correo, String contrasenia) {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()) {
			log.debug("> Entrando a UsuarioServiceImpl.obtenerUsuarioPorCorreoYContrasenia()");
		}
		contrasenia = passwordEncoder.encode(contrasenia);
		
		return usuarioRepository.findByCorreoAndContrasenia(correo, contrasenia);
	}

}
