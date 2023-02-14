import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class CryptoJsService {

  private passwordEncode: string = "1z2dxrc54tvc36yubni486n";

  constructor() { }

  encrypt(plainText: string) {
    return CryptoJS.AES.encrypt(plainText, this.passwordEncode.trim()).toString();
  }

  decrypt(encryptText: string) {
    return CryptoJS.AES.decrypt(encryptText, this.passwordEncode.trim()).toString(CryptoJS.enc.Utf8);
  }

}
