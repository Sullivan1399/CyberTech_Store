package vn.ntkiet.Controller;

import vn.ntkiet.DTO.request.postComment;
import vn.ntkiet.Entity.Comments;
import vn.ntkiet.Entity.Users;
import vn.ntkiet.Entity.Products;
import vn.ntkiet.Service.account_Service;
import vn.ntkiet.Service.comment_Service;
import vn.ntkiet.Service.user_Service;
import vn.ntkiet.Service.product_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@RequiredArgsConstructor
@Controller
public class comment_Controller
{
    private final comment_Service comment_service;
    private final account_Service account_service;
    private final user_Service user_service;
    private final product_Service product_service;
    @PostMapping("/user/postComment")
    public String post_Comment(@Valid @ModelAttribute("postComment") postComment postComment, BindingResult result)
    {
        int productID=postComment.getProductID();
        if(result.hasErrors())
        {
            return "/web/detail_product/"+productID+"#tab2";
        }
        String comment=postComment.getComment();
        int rate=postComment.getRate();
        String username=account_service.getLoggedUserName();
        Users customer= user_service.getCustomer(username);
        Products product=product_service.getProductsByID(productID);
        Comments comments=new Comments(comment,rate,product,customer);
        comment_service.postComment(comments);
        return "redirect:/web/detail_product/"+productID+"#tab2";
    }
}
