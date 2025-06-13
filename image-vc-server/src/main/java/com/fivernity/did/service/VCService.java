package com.fivernity.did.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VCService {
    public String createAndSignVc(String did, String imageUrl) throws Exception {
        Map<String, Object> vc = new HashMap<>();
        vc.put("@context", List.of("https://www.w3.org/2018/credentials/v1"));
        vc.put("type", List.of("VerifiableCredential", "ImageCredential"));
        vc.put("issuer", did);
        vc.put("issuanceDate", Instant.now().toString());

        Map<String, String> credentialSubject = new HashMap<>();
        credentialSubject.put("id", did);
        credentialSubject.put("image", imageUrl);

        vc.put("credentialSubject", credentialSubject);

        // 가짜 서명 (실제론 키쌍 서명 필요)
        vc.put("proof", Map.of(
                "type", "Ed25519Signature2018",
                "created", Instant.now().toString(),
                "proofPurpose", "assertionMethod",
                "verificationMethod", did + "#key-1",
                "jws", Base64.getEncoder().encodeToString("fake-signature".getBytes())
        ));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vc);
    }
}