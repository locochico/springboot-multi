package com.skmns.web.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.skmns.common.mapper.MemberMapper;
import com.skmns.common.model.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

  @Autowired
  private MemberMapper memberMapper;

  @RequestMapping("/member/{username}")
  public @ResponseBody String memeber(@PathVariable String username) {
    Member member = memberMapper.selectMember(username);

    log.info(member.getPassword());
    log.info("abcd");


    return member.getName();
  }

  @RequestMapping("/member/authority/{username}")
  public @ResponseBody String memberAuthority(@PathVariable String username) {
    List<String> auths = memberMapper.selectAuthority(username);

    StringBuffer buf = new StringBuffer();
    for (String auth : auths) {
      buf.append(auth);
      buf.append(" ");
    }
    return buf.toString();
  }


}
