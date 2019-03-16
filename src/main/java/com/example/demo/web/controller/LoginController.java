package com.example.demo.web.controller;

import com.example.demo.common.controller.BaseController;
import com.example.demo.web.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController extends BaseController {

    @ModelAttribute
    LoginForm loginForm(){return new LoginForm();}
    /**
     * ログイン画面表示
     * @return
     */
    @GetMapping("/loginForm")
    public String loginFrom(){
        return "login/loginForm";
    }

    /**
     * 入力チェック
     *
     * @param form
     * @param br
     * @return
     */
    @PostMapping("/login")
    public String index(@Validated @ModelAttribute LoginForm form, BindingResult br) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            return "login/loginForm";
        }
        //20190309入力チェックが通った場合は、SecurityConfigで設定した認証処理にフォワードする
        //20190309Postメソッドでなければいけないのでforwardを使う必要がある
        return "forward:" + "login";
    }

    /**
     * ログイン成功
     */
    @PostMapping("/success")
    public String loginsuccess(@ModelAttribute LoginForm loginForm, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","loginSuccess");
        return "login/Success";
    }
}
