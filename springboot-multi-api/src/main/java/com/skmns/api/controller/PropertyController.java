package com.skmns.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.skmns.common.model.SecurityMember;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PropertyController {
  @Value("${logging.path}")
  private String logging_path;

  @RequestMapping("/api/getProperty")
  public @ResponseBody String getProperty(@AuthenticationPrincipal SecurityMember securityMember) {

    StringBuffer sb = new StringBuffer();

    if (securityMember != null) {
      sb.append("securityMember.getIp()=").append(securityMember.getIp()).append(" / ");
    } else {
      sb.append("securityMember is null / ");
    }
    sb.append("logging_path=").append(logging_path);

    log.debug(sb.toString());

    return sb.toString();

  }

  @RequestMapping("/getMember")
  public @ResponseBody String getMember(@AuthenticationPrincipal SecurityMember securityMember) {

    StringBuffer sb = new StringBuffer();

    if (securityMember != null) {
      sb.append("securityMember.getIp()=").append(securityMember.getIp());
    }

    log.debug(sb.toString());

    return sb.toString();

  }


}
