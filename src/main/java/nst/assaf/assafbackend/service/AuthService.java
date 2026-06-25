package nst.assaf.assafbackend.service;

import nst.assaf.assafbackend.dto.AuthRequest;
import nst.assaf.assafbackend.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
