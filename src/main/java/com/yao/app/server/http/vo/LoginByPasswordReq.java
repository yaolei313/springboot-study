package com.yao.app.server.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * // class version 55.0 (55)
 * // access flags 0x21
 * public class com/yao/app/server/http/vo/LoginByPasswordRequest {
 *
 *   // compiled from: LoginByPasswordRequest.java
 *   // access flags 0x19
 *   public final static INNERCLASS java/lang/invoke/MethodHandles$Lookup java/lang/invoke/MethodHandles Lookup
 *
 *   // access flags 0x2
 *   private Ljava/lang/String; name
 *
 *   // access flags 0x2
 *   private Ljava/lang/String; passwordDigest
 *
 *   // access flags 0x1
 *   public <init>()V
 *    L0
 *     LINENUMBER 14 L0
 *     ALOAD 0
 *     INVOKESPECIAL java/lang/Object.<init> ()V
 *     RETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     MAXSTACK = 1
 *     MAXLOCALS = 1
 *
 *   // access flags 0x1
 *   public toString()Ljava/lang/String;
 *    L0
 *     LINENUMBER 11 L0
 *     ALOAD 0
 *     INVOKEVIRTUAL com/yao/app/server/http/vo/LoginByPasswordRequest.getName ()Ljava/lang/String;
 *     ALOAD 0
 *     INVOKEVIRTUAL com/yao/app/server/http/vo/LoginByPasswordRequest.getPasswordDigest ()Ljava/lang/String;
 *     INVOKEDYNAMIC makeConcatWithConstants(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; [
 *       // handle kind 0x6 : INVOKESTATIC
 *       java/lang/invoke/StringConcatFactory.makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *       // arguments:
 *       "LoginByPasswordRequest(name=\u0001, passwordDigest=\u0001)"
 *     ]
 *     ARETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     MAXSTACK = 2
 *     MAXLOCALS = 1
 *
 *   // access flags 0x1
 *   public getName()Ljava/lang/String;
 *    L0
 *     LINENUMBER 16 L0
 *     ALOAD 0
 *     GETFIELD com/yao/app/server/http/vo/LoginByPasswordRequest.name : Ljava/lang/String;
 *     ARETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     MAXSTACK = 1
 *     MAXLOCALS = 1
 *
 *   // access flags 0x1
 *   public getPasswordDigest()Ljava/lang/String;
 *    L0
 *     LINENUMBER 18 L0
 *     ALOAD 0
 *     GETFIELD com/yao/app/server/http/vo/LoginByPasswordRequest.passwordDigest : Ljava/lang/String;
 *     ARETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     MAXSTACK = 1
 *     MAXLOCALS = 1
 *
 *   // access flags 0x1
 *   public setName(Ljava/lang/String;)V
 *     // parameter final  name
 *    L0
 *     LINENUMBER 13 L0
 *     ALOAD 0
 *     ALOAD 1
 *     PUTFIELD com/yao/app/server/http/vo/LoginByPasswordRequest.name : Ljava/lang/String;
 *     RETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     LOCALVARIABLE name Ljava/lang/String; L0 L1 1
 *     MAXSTACK = 2
 *     MAXLOCALS = 2
 *
 *   // access flags 0x1
 *   public setPasswordDigest(Ljava/lang/String;)V
 *     // parameter final  passwordDigest
 *    L0
 *     LINENUMBER 13 L0
 *     ALOAD 0
 *     ALOAD 1
 *     PUTFIELD com/yao/app/server/http/vo/LoginByPasswordRequest.passwordDigest : Ljava/lang/String;
 *     RETURN
 *    L1
 *     LOCALVARIABLE this Lcom/yao/app/server/http/vo/LoginByPasswordRequest; L0 L1 0
 *     LOCALVARIABLE passwordDigest Ljava/lang/String; L0 L1 1
 *     MAXSTACK = 2
 *     MAXLOCALS = 2
 * }
 *
 *
 * @author yaolei313@gmail.com
 * @date 2021-08-27
 */
@ToString
@Getter
@Setter
public class LoginByPasswordReq {

    private String name;

    private String passwordDigest;
}
