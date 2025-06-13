package com.fivernity.did.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DIDService {
    public String createDid() {
        // 단순한 UUID 기반 DID (실제론 키쌍 기반이지만 간소화)
        return "did:example:" + UUID.randomUUID();
    }
}