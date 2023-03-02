package com.danilbel.cryptosystem.controllers;

import com.danilbel.cryptosystem.ciphers.symmetric.CeasarCipher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CeasarController {

    @GetMapping("/ceasar-encrypt")
    public String showCaesarEncrypt(Model model) {
        model.addAttribute("action", "Encrypt");
        return "ceasar";
    }

    @GetMapping("/ceasar-decrypt")
    public String showCaesarDecrypt(Model model) {
        model.addAttribute("action", "Decrypt");
        return "ceasar";
    }

    @PostMapping("/ceasar-encrypt/result")
    public String encrypt(@RequestParam String text, @RequestParam String key, Model model) {
        CeasarCipher cc = new CeasarCipher();
        String encrypted = cc.encrypt(text, Integer.parseInt(key));
        model.addAttribute("result", encrypted);
        model.addAttribute("action", "Encrypt");
        return "ceasar";
    }

    @PostMapping("/ceasar-decrypt/result")
    public String decrypt(@RequestParam String text, @RequestParam String key, Model model) {
        CeasarCipher cc = new CeasarCipher();
        String decrypted = cc.decrypt(text, Integer.parseInt(key));
        model.addAttribute("result", decrypted);
        model.addAttribute("action", "Decrypt");
        return "ceasar";
    }

    @GetMapping("/ceasar-brute-force")
    public String showCaesarBruteForce(Model model) {
        return "ceasar-brute-force";
    }

    @PostMapping("/ceasar-brute-force/result")
    public String bruteForce(@RequestParam("text") String text, @RequestParam("minKey") String minKey, @RequestParam("maxKey") String maxKey, Model model) {
        int min = minKey.isEmpty() ? 0 : Integer.parseInt(minKey);
        int max = maxKey.isEmpty() ? Character.MAX_VALUE : Integer.parseInt(maxKey);
        CeasarCipher cc = new CeasarCipher();
        String bruteForce = cc.bruteForce(text, min, max);
        model.addAttribute("result", bruteForce);
        return "ceasar-brute-force";
    }

}
