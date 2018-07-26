package com.bit.goodsMobile2;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

@Controller
@RequestMapping("/insertGoods.do")
public class InsertController {

   @Autowired
   private GoodsDAO dao;

   public void setDao(GoodsDAO dao) {
      this.dao = dao;
   }

   @RequestMapping(method = RequestMethod.GET)
   public void form() {

   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView submit(GoodsVO g, HttpServletRequest request, HttpSession session) {

      ModelAndView mav = new ModelAndView("redirect:/goodsTest.html");
      String path = request.getRealPath("resources/upload");
      System.out.println(path);
      try {
         String fname = "";
         MultipartFile uploadFile = g.getUploadFile();
         fname = uploadFile.getOriginalFilename();

         if (fname != null && !fname.equals("")) {

            // 파일을 사용하기 위한 객체 생성
            FileOutputStream fos = new FileOutputStream(path + "/" + fname);
            byte data[] = uploadFile.getBytes();
            fos.write(data);
            fos.close();
         } else {

            fname = "";
         }
         g.setFname(fname);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }

      int re = dao.insert(g);
      if (re < 1) {
         session.setAttribute("msg", "상품 등록 실패");
         //mav.addObject("msg", "상품 등록 실패");
      }else {
         session.setAttribute("msg", "상품 등록 성공");
         mav.addObject("msg", "상품 등록 성공");         
      }
      return mav;
   }

}