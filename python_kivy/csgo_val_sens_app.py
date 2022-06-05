from kivy.app import App
from kivy.uix.gridlayout import GridLayout
from kivy.uix.label import Label
from kivy.uix.button import Button
from kivy.uix.textinput import TextInput


class CSGO_Val_Sens_App(App):
    def build(self):
        self.window = GridLayout()
        self.window.cols = 2
        self.window.rows = 5
        self.labels = [
            Label(text='CSGO DPI'),
            Label(text='CSGO sensitivity'),
            Label(text='Valorant DPI'),
            Label(text='Valorant sensitivity')]
        self.text_inputs = [
            TextInput(input_filter='int',   multiline=False),
            TextInput(input_filter='float', multiline=False),
            TextInput(input_filter='int',   multiline=False),
            TextInput(input_filter='float', multiline=False)]
        self.buttons = [
            Button(text='CSGO to Valorant'),
            Button(text='Valorant to CSGO')] 
        for i in range(len(self.labels)):
            self.window.add_widget(self.labels[i])
            self.window.add_widget(self.text_inputs[i])
        for btn in self.buttons:
            self.window.add_widget(btn)
        self.buttons[0].bind(on_press=self.btn_on_csgo_to_valo_press)
        self.buttons[1].bind(on_press=self.btn_on_valo_to_csgo_press)
        return self.window

    def btn_on_csgo_to_valo_press(self, instance):
        if self.text_inputs[0].text == '': return
        if self.text_inputs[1].text == '': return
        if self.text_inputs[2].text == '': return
        valo_sens = (float(self.text_inputs[1].text) / 3.18) * (float(self.text_inputs[0].text) / float(self.text_inputs[2].text))
        self.text_inputs[3].text = str(valo_sens)

    def btn_on_valo_to_csgo_press(self, instance):
        if self.text_inputs[0].text == '': return
        if self.text_inputs[2].text == '': return
        if self.text_inputs[3].text == '': return
        csgo_sens = (float(self.text_inputs[3].text) * 3.18) * (float(self.text_inputs[2].text) / float(self.text_inputs[0].text))
        self.text_inputs[1].text = str(csgo_sens)


if __name__ == "__main__":
    CSGO_Val_Sens_App().run()
