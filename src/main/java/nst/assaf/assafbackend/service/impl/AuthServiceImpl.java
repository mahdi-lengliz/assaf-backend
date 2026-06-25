package nst.assaf.assafbackend.service.impl;

import nst.assaf.assafbackend.dto.AuthRequest;
import nst.assaf.assafbackend.dto.AuthResponse;
import nst.assaf.assafbackend.model.AdminUser;
import nst.assaf.assafbackend.repository.AdminUserRepository;
import nst.assaf.assafbackend.security.JwtService;
import nst.assaf.assafbackend.service.AuthService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AdminUser admin = adminUserRepository.findByUsername(request.username())
                .orElseThrow(() -> new BadCredentialsException("Identifiants invalides"));
        if (!passwordEncoder.matches(request.password(), admin.getPassword())) {
            throw new BadCredentialsException("Identifiants invalides");
        }
        return new AuthResponse(jwtService.generateToken(admin.getUsername(), admin.getRole()), admin.getUsername(), admin.getRole());
    }
}
