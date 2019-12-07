package maymanm.drugsapp.base.constantsutils;

/**
 * Created by MAyman on 4/2/18.
 */

public class WebServices {
    //Status
    public static final int SUCCESS = 200;
    public static final int FAILED = 401;
    public static final int NOT_FOUND = 404;
    public static final int NOT_ACTIVE = 402;
    public static final int LOGIN_FIRST = 403;

    public static final String TYPE_USER = "user";
    public static final String TYPE_WORKER = "worker";

    public static final String PROFILE = "user/profile";
    public static final String IMAGE_TEST = "https://dummyimage.com/600x600/DB4437/fff";
    public static final String GET_OFFER_PRODUCTS = "OfferShopsWithProducts";
    public static final String REGISTER_COMPLETE = TYPE_WORKER + "/register/complete";
    public static final String HOME_DATA = TYPE_WORKER + "/home";
    public static final String GET_CATEGORIES = TYPE_WORKER + "/sub-categories?category_id=";
    public static final String CREATE_ORDER = TYPE_WORKER + "/create-order";
    public static final String GEO_LOCATION_ADDRESS = "https://maps.googleapis.com/maps/api/geocode/json?";
    public static final String GET_CITIES = "cities";
    public static final String ACCEPT_ORDER_OFFER = TYPE_WORKER + "/accept-offer";
    public static final String REJECT_ORDER_OFFER = TYPE_WORKER + "/reject-offer";
    public static final String GET_ORDER_OFFERS = TYPE_WORKER + "/order-offers?order_id=";
    public static final String GET_CHAT = "user/chat?type=1&shop_id=";
    public static final String SEND_MESSAGE = "user/chat/createShopChat";
    public static final String GET_COUNTRIES = "getCountries";
    public static final String GET_SHOP_DEPARTMENT = TYPE_USER + "/getCategory";
    public static final String CHECK_SHOP_PASSWORD = TYPE_USER + "/checkPasswordShop";
    public static final String CHANGE_FAVOURITE_PRODUCT = TYPE_USER + "/createFavoriteProduct";

    public static final String CHANGE_FAVOURITE_SHOP = TYPE_USER + "/createFavoriteShop";
    public static final String RATE_PRODUCT = TYPE_USER + "/addRateProduct";
    public static final String GET_SHIPPING_COMPANY = TYPE_USER + "/getShippingCompany";
    public static final String GET_CARDS = "card";
    public static final String GET_SETTINGS = "notifications/setting";
    public static final String ADD_PACKING_CARD = "addUserCard";
    public static final String PAY_WITH_CARD = "order/packingCard";
    public static final String TRANSFER_PACKING_CARD = "sendMoney";
    public static final String RECEIVE_PACKING_CARD = "receiveMoney";
    public static final String SWITCH_NOTIFICATION = "notifications/statusNotification";
    public static final String SEARCH_SHOPS = "user/searchShops";
    public static final String ADD_SHOP = "shops/addShop";
    public static final String GET_SELLERS_POINTS = "SellerPoints";
    public static final String CHECK_PHONE_REGISTER = "checkPhoneRegister";
    public static final String CHANGE_FOLLOW = "user/createFollowShop";


    //URLS
    private static final String BaseSiteName = "em";
    public static final String BASE_URL = "http://" + BaseSiteName + ".my-staff.net/api/";
    public static final String LOGIN = "login";
    public static final String VERIFY_CODE = TYPE_WORKER + "/verify-code";
    public static final String REGISTER = "register";
    public static final String ABOUT_US = "about_us";
    public static final String CHECK_PHONE = "checkPhone";
    public static final String CHANGE_PASSWORD = TYPE_USER + "/profile/change_password";
    public static final String FAQ = "FAQ";
    public static final String SEARCH = TYPE_WORKER + "/searchForShops";
    public static final String PRIVACY_TERMS = "terms_and_conditions";
    public static final String SUGGESTION = "suggestion/add";
    public static final String PROMO_CODE = "promo/apply";
    public static final String SERVICES = "services";
    public static final String GET_ALL_SHOPS = TYPE_WORKER + "/FilterShopbylatlng";
    public static final String GET_SHOPS = TYPE_USER + "/shops";
    public static final String GET_REVIEWS = TYPE_WORKER + "/view_comments";
    public static final String SEND_COMMENT = TYPE_WORKER + "/user_review";
    public static final String GET_OFFERS = "Shops/offers";
    public static final String GET_SIZES = "Product/ShowSizes";
    public static final String GET_PRODUCT_DETAIL = TYPE_USER + "/getDetailsProduct";
    public static final String GET_COLORS = "Product/ShowColors";
    public static final String EDIT_PROFILE = TYPE_USER + "/profile/edit";
    public static final String GET_WISHLIST = TYPE_WORKER + "/favorite";
    public static final String ADD_UPDATE_CART = TYPE_USER + "/cart/add_or_update";
    public static final String GET_CART = TYPE_USER + "/cart";
    public static final String UPDATE_ADDRESS = "order/user/updateAddress";
    public static final String GET_MY_ORDERS = "order/" + TYPE_USER + "/list";
    public static final String GET_SHOP_DETAILS = "ShopWithCategory";
    public static final String GET_PRODUCTS = TYPE_USER + "/productsFromCategory";
    public static final String GET_FAVOURITES = TYPE_USER + "/favorite";
    public static final String GET_TRANSITIONS = "order/Transfer/" + TYPE_WORKER + "/list";
    public static final String GET_TRANSITION_DETAILS = "order/Transfer/" + TYPE_WORKER + "/OrderDetails";
    public static final String GET_NOTIFICATION = "notifications?type=1";
    public static final String UPDATE_LOCATION = "update_location";
    public static final String GET_SHOPS_FILTER = TYPE_WORKER + "/FilterWithBestShops";
    public static final String DELETE_CART = TYPE_USER + "/cart/delete";
    public static final String GET_ORDER_ID = "order/" + TYPE_WORKER;
    public static final String GET_ORDER_DETAILS = "order/user/orderDetails?type=1&order_id=";
    public static final String SEND_TRANSFER_ORDER = "order/transfer";
    public static final String CONFIRM_ORDER = "order/user/confirm";
    public static final String SETTINGS = "settings?";

    //params
    public static String USER_NAME = "user_name";
    public static final String PHONE = "phone";
    public static final String GOOGLE_TOKEN = "google_token";
    public static final String USER_PROFILE = "profile_image";

    public static final String IMAGE = "image";
    public static final String USER_IMAGE = "user_image";
    public static final String License = "license";
    public static final String DELEGATE_ID = "delegate_id";


}
