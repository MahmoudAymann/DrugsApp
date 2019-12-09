package maymanm.drugsapp.viewmodel.fragment.main;

import androidx.databinding.ObservableField;

import java.util.ArrayList;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.util.ErrorsUtil;
import maymanm.drugsapp.view.adapter.parent.ChatAdapter;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class DisabledViewModel extends BaseViewModel {

    public ChatAdapter chatAdapter = new ChatAdapter();
    public ObservableField<String> obsMessage = new ObservableField<>();

    public DisabledViewModel() {

    }

    public void onSendClick() {
        if (ErrorsUtil.isEmptyString(obsMessage.get())) {
            return;
        }
        chatAdapter.addItem(obsMessage.get(), 1);
        getRobotMessage(obsMessage.get());
        obsMessage.set("");
        setValue(Codes.PRESS_BACK);
    }

    private void getRobotMessage(String senderMessage) {
        String answer = "sorry i can't understand";
        ArrayList<String> questions = getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(0).trim().toLowerCase().equals(senderMessage.trim().toLowerCase())) {
                answer = getString(R.string.string23);
                break;
            } else if (questions.get(1).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string1);
            } else if (questions.get(2).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string2);
            } else if (questions.get(3).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string3);
            } else if (questions.get(4).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string4);
            } else if (questions.get(5).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string5);
            } else if (questions.get(6).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string6);
            } else if (questions.get(7).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string7);
            } else if (questions.get(8).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string8);
            } else if (questions.get(9).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string9);
            } else if (questions.get(10).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string10);
            } else if (questions.get(11).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string11);
            } else if (questions.get(12).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string12);
            } else if (questions.get(13).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string13);
            } else if (questions.get(14).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string14);
            } else if (questions.get(15).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string15);
            } else if (questions.get(16).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string16);
            } else if (questions.get(17).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string17);
            } else if (questions.get(18).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string24);
            } else if (questions.get(19).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string18);
            } else if (questions.get(20).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string19);
            } else if (questions.get(21).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string20);
            } else if (questions.get(22).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string21);
            } else if (questions.get(23).trim().toLowerCase().equals(senderMessage)) {
                answer = getString(R.string.string22);
            } else if (questions.get(24).trim().toLowerCase().equals(senderMessage)) {
                answer = "hi, how can i help you? :)...";
            }
        }
        chatAdapter.addItem(answer, 2);
    }


    private ArrayList<String> getQuestions() {
        ArrayList<String> list = new ArrayList<>();
        list.add("when i am leaving a blind person, what should i do?");
        list.add("do the blind people always need acute supervision?");
        list.add("what is the difference between the low vision and the blind?");
        list.add("i feel terrible when i see someone blind");
        list.add("do the blind feel as insulted by overcompensating kindness, as by judgment?");
        list.add("i know that the blind has super-sensory, have heightened senses is that true?");
        list.add("i spoke to the blind with non-normal language");
        list.add("are they as responsive and engaging with their environment, as any other human or not?");
        list.add("does the blind dream while sleeping?");
        list.add("does the blind understand colors?");
        list.add("does all of the blind use a cane");
        list.add("are the blind open to curious inquiries about their situation?");
        list.add("is blind's success also depending on how I view them?");
        list.add("what shall I do to avoid hurting their feelings?");
        list.add("some tips about dealing with the blind");
        list.add("how to speak to someone with disability?");
        list.add("what could harm people with disability");
        list.add("is that with the loss of one of the senses such as sight or hearing, the other senses automatically compensate and become sharper?");
        list.add("are People with disabilities heroic because they demonstrate bravery and courage by trying to overcome their disability?");
        list.add("is Most people with disabilities would be better off living in institutions where their needs can be met?");
        list.add("is People with mental illness are potentially violent or incapable of participating in the community, and people without disabilities should be protected from them?");
        list.add("does People with disabilities should be served separately and with special procedures to ensure that they can receive quality services while not affecting the services to others?");
        list.add("is Simply treating everyone in the same manner will lead to people with disabilities being served appropriately?");
        list.add("what are the appropriate ways to call various disabilities?");
        list.add("hi");
        return list;
    }

}
