package maymanm.drugsapp.base.constantsutils;

import com.google.zxing.common.StringUtils;

import maymanm.drugsapp.R;

import static maymanm.drugsapp.util.ApplicationUtil.getString;

/**
 * Created by MahmoudAyman on 12/8/2019.
 **/
public class JsonStrings {

    private String drug1 = "{\n" +
            "    \"status\": 200,\n" +
            "    \"message\": \"عرض البيانات بنجاح\",\n" +
            "    \"data\": {\n" +
            "        \"drugs\": [\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 1,\n" +
            "                \"name\": \"Aspocid c\",\n" +
            "                \"rate\": \"4\",\n" +
            "                \"image\": \"https://www.l2tat.com/wp-content/uploads/2019/03/Aspocid.jpg\",\n" +
            "                \"composition\": \"acetyl salicylic acid 500mg, vit c 500g\",\n" +
            "               \"dose\": \" for adult: each effervescent tablet contains aspirin 400mg and ascorbic acid 240mg. 1-2 tablets, may repeat every 4 hrly, if necessary. Max: 8 tablets/24 hr.\",\n" +
            "                \"indication\": \"mild to moderate pain and fever\",\n" +
            "                \"contraindications\": \"Gastric or duodenal ulcers. Haemophilia, thrombocytopenia or other bleeding tendencies; patients receiving anti-coagulant treatment. Hypersensitivity to aspirin or other salicylates or ascorbic acid. Severe renal impairment.\",\n" +
            "                \"precautions\": \"special precautions Risk of Reye’s syndrome in children with varicella infection or influenza like illnesses. Not to be used for >10 days without medical advice. Treatment should be withdrawn 1 wk prior to surgery to prevent or reduce risk of bleeding complications. Caution when used in patients with impaired renal function, severe hepatic impairment, history of GI discovers e.g. peptic ulcers ulcerative colitis and Crohn’s disease, dyspepsia and when the patient is dehydrated. Pregnancy and lactation.\",\n" +
            "                \"interactions\": \"aspirin may increase hypoprothrombinemic effect of warfarin and other oral anticoagulants, thus increasing the risk of bleeding complications. May antagonize uricosuric effect of probenecid, phenyibutazone or sulfinpyrazone. Concuuent admin with corticosteroids may reduce the serum levels pf aspirin. Aspirin may increase serum levels of methotrexate. Concurrent admin with alcohol increases risk and severity of GI bleeding and ulceration. Aspirin my reduce the absorption of vitamin C.\",\n" +
            "                \"side_effects\": \"Dizziness, GI irritation e.g. dyspepsia, nausea. Vomiting, erosion, ulceration, haematemesis and melaena. Prolonged use of high doses of aspirin may cause haemorrhage and peptic ulceration\",\n" +
            "                \"overdose\": \"Overdose of aspirin can lead to dizziness, tinnitus, sweating, nausea. Vomiting, altered glucose metabolism, mental confusion, hyperventilation, respiratory alkalosis, metabolic acidosis, ketosis, fluid and electrolyte losses. CNS depression may lead to coma, CV collapse and respiratory failure, Overdosage of vitamin C may lead to diarrhea and GI disturbances. Treatment includes gastric lavage, forced alkaline diuresis, restoration of fluid, electrolyte and acid balance, dialysis and supportive therapy may be needed.\",\n" +
            "                \"pharmacology\": \"Aspirin has pain relieving, antipyretic and anti-inflammatory actions. Vitamin C is a water-soluble vitamin that is used with aspirin for the relief of pain and/or fever associated with colds and flu. Absorption: Vitamin C; Readily absorbed via oral admin. Metabolism: Vitamin C; Hepatic via oxidation and sulfation.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 1,\n" +
            "                  \"name\": \"12 Tablets\",\n" +
            "                  \"description\": \"500 mg\",\n" +
            "                  \"cost\":\"15egp\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              \n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\":2,\n" +
            "                \"name\": \"Allercet\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQmpDjI6CWnDjZgDOG630uw_V_wMlopVVGDYlWhqjTKNZjG3k__\",\n" +
            "                \"composition\": \"Pseudoephedrine HCl 30mg, cetirizine HCl 10mg.\",\n" +
            "                \"dose\": \": Adults & children over 12 years of age: one capsule to be taken once daily as directed.\",\n" +
            "                \"indication\": \"relief of symptoms due to hay fever or other upper respiratory allergies such as: Nasal congestion, runny nose, sneezing, itchy, watery eyes, itching of the nose or throat, swelling of nasal passages, since congestion & pressure, thus, temporarily restores free breathing through the nose.\",\n" +
            "                \"contraindications\": \"known hypersensitivity reactions to any of the components of the produce. Severe hypertension & coronary artery disease. Patients taking monoamine oxidase inhibitors.\",\n" +
            "                \"precautions\": \"lactation: as it is excreted in breast milk, avoid in lactating women. pregnancy: safety for use during pregnancy hasn’t been established. Use only when clearly needed & when the potential benefits outweigh the potential hazards to the fetus. Don’t use during the third trimester. studies have no revealed effects on alertness or reaction time, however, patients are advised not to exceed the recommended dose if driving or operating machinery. care in patients with hypertension or other cardiovascular disease, hyperthyroidism, diabetes mellitus, prostatic hypertrophy. Rene, impairment or angle-closure glaucoma. pregnancy: lactation, each ingredient is distributed in breast milk, caution advised.\",\n" +
            "                \"interactions\": \"contraindicated(9), iobenguane I 123, isocarboxazid, linezolid, phenelzine, procarbazine, rasagiline, selegiline, selegiline transdermal, tranylcypromine, serious-use Alternative (29), amitriptyline, amoxapine, cabergoline, clomipramine, desflurane, desipramine, dihydroergotamine, dihydroergotamine intranasal, dosulepin, doxa pram, doxepin, enflurane, ergoloid mesylates, ergonovine, ergotamine, ether, imipramine, isocarboxazid, isoflurane, maprotiline, methoxyflurane, methylergonovine, mainserin, nortriptyline, protriptyline, sevoflurane, tranylcypromine, sevoflurane, tranylcypromine, trazodone.\",\n" +
            "                \"side_effects\": \"Reports of mild & transient side effects such as headache, dizziness, drowsiness, agitation, dry mouth & gastro-intestinal discomfort. The commonest side effects of pseudoephedrine include tachycardia, increase in blood pressure, anxiety, restlessness, & insomnia; skin rashes & urinary retention have occasionally occurred\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Allercet is a combination of 2 active ingredients, pseudoephedrine as decongestant & cetirizine as antihistamine. Pseudoephedrine, decongestant, is a sympathomimetic with direct & indirect effects on adrenergic receptors. It has alpha & beta adrenergic activity & has pronounced stimulating effects on the central nervous system. Due to its alpha-adrenergic effects, intense vasoconstriction to mucous membranes results in their shrinkage; this promotes drainage, thus improving ventilation & nasal stuffiness. It is longer duration of action, less local irritation & not associated with rebound congestion. Cetirizine dihydrochloride, antihistamine, is a piperazine derivate & metabolite of hydroxyzine. It is a non-sedating, selective antagonist of the peripheral histamine (H1) receptor, with free anticholinergic & antiserotonergic effects. It is reported to be long-acting & with some mast-cell stabilizing activity. It inhibits the histamine-mediated “early” phase of the allergic reaction & also reduces the migration of inflammatory cells & the release of mediators associated with the “late” allergic response. Allercet relieves the symptoms of allergies like hay fever (seasonal rhinitis) including nasal & sinus congestion.\",\n" +
            "                \"packaging\": \"Allercet capsules are supplied in boxes of 20 capsules each.\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 2,\n" +
            "                  \"name\": \"20 Tablets\",\n" +
            "                  \"description\": \"300 mg\",\n" +
            "                  \"cost\": \"18 egp\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 3,\n" +
            "                \"name\": \"Clearest\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRfsYgcwArTKwdnYyAnPZdJippj7i7CYwuq9W4gY-u_Q3rDpBC3\",\n" +
            "                \"composition\": \"Cetirizine 5mh, pseudoephedrine 120mg.\",\n" +
            "                \"dose\": \"Adult: Allergic Rhinitis, indicated to relieve nasal and non-nasal symptoms associated with seasonal or perennial allergic rhinitis, 1 tablet PO q12hr with or without food. Elderly: may required decreased dose of 1 tablet qDay. Renal/Hepatic impairment Hemodialysis or CrCl <32ml/min: 1 tablet PO qDay. Hepatic impairment: 1 tablet Po qDay. Pediatric, Allergic Rhinitis, indicated to relieve nasal and non-nasal symptoms associated with seasonal or perennial allergic rhinitis. <12 years or older: As adults; 1 tablet PO q12hr with or without food.\",\n" +
            "                \"indication\": \"Allergic Rhinitis.\",\n" +
            "                \"contraindications\": \"Hypersensitivity, Narrow-angle glaucoma, Urinary hypertension, Severe Coronary hypertension, Severe coronary artery disease, don’t take within 14 days of MAOIs.\",\n" +
            "                \"precautions\": \": Adrenergic agents may cause arrhythmias, dizziness, insomnia, tremor, or weakness. May cause sedation; caution with tasks requiring cognitive abilities (eg, driving, operating machinery). Alcohol may exacerbate sedation and cognitive abilities. Caution with history of diabetes mellitus, hypertension, hyperthyroidism, increased IOP, ischemic heart disease, prostatic hypertrophy, or renal function impairment.\",\n" +
            "                \"interactions\": \"contraindicated(9), iobenguane I 123, isocarboxazid, linezolid, phenelzine, procarbazine, rasagiline, selegiline, selegiline transdermal, tranylcypromine, serious-use Alternative (29), amitriptyline, amoxapine, cabergoline, clomipramine, desflurane, desipramine, dihydroergotamine, dihydroergotamine intranasal, dosulepin, doxa pram, doxepin, enflurane, ergoloid mesylates, ergonovine, ergotamine, ether, imipramine, isocarboxazid, isoflurane, maprotiline, methoxyflurane, methylergonovine, mainserin, nortriptyline, protriptyline, sevoflurane, tranylcypromine, sevoflurane, tranylcypromine, trazodone.\",\n" +
            "                \"side_effects\": \"1-10% Insomnia (4%), Xerostomia(4%), Fatigue/somnolence(2%), Pharyngitis(2%), Dizziness(1%), Epistaxis(1%), Sinusitis(1%).\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Half-life:70hr (cetirizine); 5-8hr (pseudoephedrine). Onset:20-60min (cetirizine); 30min (pseudoephedrine). Vd: 2.6-3.3 L/Kg (cetirizine). Peak Plasma Time:0.5-1.5hr (cetirizine); 1.97hr (pseudoephedrine). Peak Plasma Concentration: 422ng/mL (pseudoephedrine). Protein Bound: 96% (cetirizine). Metabolism: liver, low first pass (cetirizine). Clearance: 7.3-7.6mL/min/Kg (pseudoephedrine). Excretion: cetirizine: feces (10%), urine (70%); pseudoephedrine: urine. Mechanism of action: Cetirizine: Histamine H1-receptor antagonist. Pseudoephedrine: Alpha-adrenergic agonist.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Lactation: Each ingredient is distributed in breast milk, caution advised.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 3,\n" +
            "                  \"name\": \"14 Tablets\",\n" +
            "                  \"description\": \"120 mg\",\n" +
            "                  \"cost\": \"21 egp\"\n" +
            "                  }\n" +
            "                ]},\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 4,\n" +
            "                \"name\": \"Sinlerg\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTk1AnAUasHDEpZUYhRSZEG8AeMxyfBIM7bkfDVyy-8C6w0iBMJ\",\n" +
            "                \"composition\": \"Chlorpheniramine maleate 2mg. ibuprofen 200mg pseudoephedrine 30mg.\",\n" +
            "                \"dose\": \"2 tablets up to 3 times daily\",\n" +
            "                \"indication\": \"Sinlerg treats the multi-symptoms of: Nasal & sinus congestion. Sneezing & runny nose, headache and muscle pain associated with common cold fever.\",\n" +
            "                \"contraindications\": \"In case you are allergic to any ingredient in Sinlerg. In case you had a severe allergic reaction (eg, severe rash, hives, trouble breathing, growths in the nose, dizziness) to aspirin or an NSAID (eg, ibuprofen, celecoxib). In case you have recently had or will be having bypass heart surgery. In case you have severe high blood pressure, severe heart blood vessel disease, rapid heartbeat, or severe heart problems. In case you are taking sodium oxybate (GHB) or if you have taken furazolidone or a monoamine oxidase inhibitor (MAOI) (eg, phenelzine) within the last 14 days.\",\n" +
            "                \"precautions\": \"ask your doctor: if you are pregnant, planning to become pregnant, or are breast-feeding if you are taking any prescription or nonprescription medicine, herbal preparation, or dietary supplement, if you have allergies to medicines, foods, or other substances, if you have history of adrenal gland problems (eg, adrenal gland tumor), asthma, stomach or bowel problems (eg, bleeding, perforation, persistent or returning stomach pain or heartburn, ulcers), heart problems (eg, heart failure), high blood pressure, diaetes, blood disorders, bleeding or clotting problems, stroke, glaucoma or increased eye pressure, an enlarged prostate or other prostate problems, seizures, an overactive thyroid, kidney problems, liver problems (eg, hepatits), or if you are at risk for any of these diseases, if you have a history of swelling or fluid buildup, lupus, asthma, growths in the nose (nasal polyps), or mouth inflammation, if you have fast, slow, or irregular heartbeat; or if you are dehydrated or have low fluid volume (eg, caused by diarrhea, not drinking fluids, vomiting).\",\n" +
            "                \"interactions\": \": anticoagulants (eg, warfarin), aspirin, corticosteroids (eg, prednisone), heparin, or selective serotonin reuptake inhibitors (SSRIs) (eg, fluoxetine) because the risk of stomach bleeding may be increased. Beta-blockers (eg, propranolol), catechol-o-methyltransferase (COMT) inhibitors (eg, tolcapone), furazolidone, indomethacin, isoniazid, MAOIs (eg, phenelzine), probenecid, or tricyclic antidepressants (eg, amitriptyline) because they increase the risk of side effects Bromocriptine, cyclosporine, hydantoins (eg, phenytoin), lithium, methotrexate, or quinolones (eg, ciprofloxacin) because the risk of their side effect may be increased by Sinlerg. Angiotensin-converting enzyme (ACE) inhibitors (eg, enalapril) diuretics (eg, furosemide, hydrochlorothiazide), guanadrel, guanethidine, mecamylamine, methyldopa, or reserpine because their effectiveness may be decreased by Sinlerg Caplets\",\n" +
            "                \"side_effects\": \"constipation, diarrhea, dizziness, drowsiness, excitability, headache, loss of appetite, nausea, nervousness or anxiety, trouble sleeping, upset stomach, vomiting, weakness.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"a combination therapy for pain/fever relief, nasal decongestion & Antihistamine.\",\n" +
            "                \"packaging\": \"Carbon box containing 2 blisters each of 10 coated tablets.\",\n" +
            "                \"pregnancy\": \"not to be used at pregnancy and lactation especially the first three months of pregnancy.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 4,\n" +
            "                  \"name\": \"20 Tablets\",\n" +
            "                  \"description\": \"200 mg\",\n" +
            "                  \"cost\": \"21 egp\"\n" +
            "                  }\n" +
            "                ]\n" +
            "                },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 5,\n" +
            "                \"name\": \"Cold control\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTjZkxRUmT922lBCGrrtPX39qmc6aCVvhscLjiOQB5IDeop7XSB\",\n" +
            "                \"composition\": \"Active Ingredients: Acetaminophen 500mg. Diphenhydramine HCl 12.5mg\",\n" +
            "                \"indication\": \"Runny nose, sneezing, headache, minor aches and pains, itching of the nose or throat and itchy, watery eyes due to hay fever.\",\n" +
            "                \"dose\": \"Adults & Children 12 years and over: take 2 F.C. Tablets every 4 to 6 hours; not more than 8 F.C. Tablets in 24 hours: Don’t use this adult product.\",\n" +
            "                \"contraindications\": \"with any other product containing acetaminophen or diphenhydramine. Cold Control is contraindicated to patients are now taking a prescription Monamine oxidase inhibitors (MAOI), or for 2 weeks after stopping the MAOI drug. Don’t use below age of 12 years.\",\n" +
            "                \"precautions\": \"Alcohol consumers, (with alcohol acetaminophen may cause liver damage). Ask to doctor before use if you have: Glaucoma, trouble urinating due to enlarge prostate gland, a breathing problem such as emphysema or chronic bronchitis. Alcohol, sedatives and tranquilizers may increase drowsiness. Be careful when driving a motor vehicle or operating machinery. Instructions to patients: Don’t use below age of 12 years and stop drug if: Pain gets worse or lasts more than 10 days or if fever gets worse or lasts more than 3 days.\",\n" +
            "                \"interactions\": \"Monamine oxidase inhibitor (MAOI), responsible for the metabolism of some beta blockers including Metoprolol and Venlaxafine.\",\n" +
            "                \"side_effects\": \"May cause some sedative effects as drowsiness, in-coordination. These sedative effects when they occur may diminish after a few days of treatment.\",\n" +
            "                \"overdose\": \"Taking more than the recommended dose (over dose) may cause liver damage\",\n" +
            "                \"pharmacology\": \"Pharmacological action: Acetaminophen is a pain reliever and fever reduce. Acetaminophen produces analgesia by elevation of the pain threshold and antipyresis through action on the hypotha-lamic heat regulation center. Acetaminophen is equal to aspirin in analgesic and antipyretic effectiveness. Diphenhydramine is an antihistaminic which helps provide temporary relief of itchy, watery eyes, runny nose, sneezing, Itching of the nose or throat due to hay fever or other respiratory allergies. Pharmacokinetics: Acetaminophen is readily absorbed from gastrointestinal tract with peak plasma concentrations occurring about 10 to 60 minutes after oral doses. It is distributed into most body tissues. It is metabolized predominantly in the liver. The elimination half life varies from about 1 to 3 hours. It is excreted in the urine. Diphenhydramine hydrochloride is well absorbed from gastrointestinal tract with peak plasma concentrations occurring about 1 to 4 hours after oral does. It is widely distributed throughout in the body including the CNS. It is highly bound to plasma proteins. The elimination half life varies from about 2.4 to 9.3 hours. It is excreted in the urine.\",\n" +
            "                \"packaging\": \"carton box containing one or two strips. (AL/PVC) each one contains 10 film coated tablets and inner leaflet.\",\n" +
            "                \"pregnancy\": \"Not to be used for neither pregnant nor nursing mothers.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 5,\n" +
            "                  \"name\": \"20 Tablets\",\n" +
            "                  \"description\": \"500 mg\",\n" +
            "                  \"cost\": \"20 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "                  \n" +
            "                },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 6,\n" +
            "                \"name\": \"Villapurg\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSX9C6bzK70pB9ul0B9P_ps9w_EuJduQUKtVIr46_teieA4NeSV\",\n" +
            "                \"composition\": \"lactulose 67%\",\n" +
            "                \"dose\": \"Adult constipation, solution: 15-30ml (10-20g) PO once daily; may be increased to 60ml (40g) once daily. Crystals: 10-20g PO qDay; may increase to 40g/day. Portal Systemin, Encephalopathy, Prophylaxis. 30-45mL (20-30g) PO q6-8hr, adjusted until 2-3 soft stools/day; if acute, may be given q1-2hr until 2-3 soft stools/day. Treatment: 20-30g (30-45mL) PO q1hr to induce rapid defection; reduced to 20-30g q6-8hr after defecation achieved; titrated to produce 2-3soft stools/day. 300mL (200g) PR with 700mL water or NS, retained for 30-60min; may be repeated q46hr; transition to oral treatment before discontinuance of rectal administration. Pediatric constipation, 0.7-2g/Kg/day (1-3mL/Kg/day) PO in divided doses; not to exceed 40 g/day (60mL/day). Portal systemic encephalopathy prophylaxis. Infants: 2.5-10 mL/day (1.7-6.67g/day) PO in divided doses; titrated to produce 2-3 soft stools/day. Children and adolescents: 40-90 mL/day (26.7-60g/day) PO in divided doses; titrated to produce 2-3soft stools/day. \",\n" +
            "                \"indication\": \"Constipation, portal Systemic, encephalopathy.\",\n" +
            "                \"contraindications\": \"Galactosemia (patients require low-galactose diet).\",\n" +
            "                \"precautions\": \"Diabetes (preparation contains lactose and galactose). Monitor for electrolyte imbalance when drug is used for >6 months or in patients predisposed to electrolyte abnormalities. Avoid using other laxatives concomitantly. Inadequate response possible when taken concomitantly with anti-infective.\",\n" +
            "                \"interactions\": \"contraindicated (0), serious- Use Alternative (0).\",\n" +
            "                \"side_effects\": \"Frequency not defined dehydration, diarrhea, excessive bowel activity, hypernatremia, hypokalemia, nausea, vomiting, abdominal cramping, abdominal distention, belching, flatulence.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of action: Constipation: Hyperosmotic agent increases stool water contents, softens stools water contents, softens stool, promotes peristalsis, and reduces blood ammonia concentration. Portal systemic encephalopathy: breakdown of lactulose to organic acids by colonic bacteria acidifies colonic contents, thereby subsequently inhibiting diffusion of ammonia back to blood; agent also enhances diffusion of NH3 from blood into gut, where it is converted to NH4. Absorption: bioavailability: <3% absorbed. Onset:24-48hr. Metabolism: absorbed lactulose is not metabolized; unabsorbed lactulose is extensively metabolized to organic acids by colonic bacteria. Metabolites: lactic acid (main), formic acid, acetic acid (all active). Elimination: Excretion: urine (absorbed lactulose), feces and bile (unabsorbed lactulose), feces and bile (unabsorbed lactulose and metabolites; mineral).\",\n" +
            "                \"packaging\": \"not repoted\",\n" +
            "                \"pregnancy\": \"Lactation: Unknown whether drug is distributed into milk; use with caution.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 6,\n" +
            "                  \"name\": \"1 syrup\",\n" +
            "                  \"description\": \"120 mg\",\n" +
            "                  \"cost\": \"12 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 7,\n" +
            "                \"name\": \"Agiolax\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQuY_KZQSqCPyeDEIJdPsv9iLQIZoKnu5sGr4ntzbKHYPqGT8N3\",\n" +
            "                \"composition\": \"Seeds of Plantago ovata 52.0g, Isphagula husk, 2.2 g Tinnevelly Senna pods 12.4g.\",\n" +
            "                \"dose\": \"Agiolax should be taken after the evening meal and before breakfast. The general dosage is 1 – 2 teaspoonful/sachet(s)–according to the individual requirement – followed by a glass of water. Agiolax should not be chewed. After the preparation has been effective, the dosage can be individually reduced to ½ to 1 teaspoonful/sachet once or twice daily.\",\n" +
            "                \"indication\": \"Constipation, particularly the chronic form. Regulation of bowel activity during pregnancy and post-partum. In patients confined to bed. Habituation to strong purgatives. Disordered bowel action in patients with colostomies.\",\n" +
            "                \"contraindications\": \"Hypersensitivity to Agiolax Granules is a contraindication. In addition, Agiolax Granules should not be used if you have the following conditions: Abdominal pain, Acute intestinal inflammation, Appendicitis, Hypersensitivity, Intestinal obstruction, Ulcerative colitis.\",\n" +
            "                \"precautions\": \"not reported\",\n" +
            "                \"interactions\": \"not reported\",\n" +
            "                \"side_effects\": \"Heart function disorders, Cramps, Stomach aches, Stomach pain, Diarrhea, Muscle weakness, Nausea, Difficulty in breathing, Difficulty in swallowing, Skin rash, Agiolax Granules may also cause side-effects not listed here.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Agiolax regulates the bowel function in natuar way, its action is based on swelling with water to produce a soft and easily excreted stool. The senna pods have a supplementary effect in accelerating bowel transit. Agiolax does not cause any undesirable side effects.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 7,\n" +
            "                  \"name\": \"12 sach\",\n" +
            "                  \"description\": \"\",\n" +
            "                  \"cost\": \"16.5 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 8,\n" +
            "                \"name\": \"Metamucil orange sugar free\",\n" +
            "                \"rate\": \"3\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS_mol0mW5y4IY-nYuhMOPenVSzdiaLQ2TGueAzmjGWdYPlbtPL\",\n" +
            "                \"composition\": \"psyllium\",\n" +
            "                \"dose\": \"For adults: 19 to 50 years: Male: 38 g/day; Female: 25 g/day, Pregnancy: 28 g/day, Lactation: 29 g/day, 1 to 2 rounded teaspoonfuls, 1 to 2 packets, 1 to 2 wafers, or 5 to 6 capsules orally with 8 ounces of fluid 1 to 3 times a day. Children 1 to 3 years: 19 g/day, Children 4 to 8 years: 25 g/day, Children 9 to 13 years: Male: 31 g/day; Female: 26 g/day, Children 14 to 18 years: Male: 38 g/day; Female: 26 g/day, Children 6 to 11 years: 1.25 to 15 g orally per day in divided doses, Children greater than or equal to 12 years and Adults: 2.5 to 30 g per day in divided doses.\",\n" +
            "                \"indication\": \"other indications & uses, off-label: IBS, hypercholesterolemia\",\n" +
            "                \"contraindications\": \"Hypersensitivity, GI obstruction, fecal impaction, symptoms of appendicitis or acute surgical abdomen, GI ulceration, dysphagia, rectal bleeding.\",\n" +
            "                \"precautions\": \"Lactation: no data available; not absorbed, therefore it is unlikely to pose the risk in breast-feeding.\",\n" +
            "                \"interactions\": \"contraindicated (0), serious- Use Alternative (0), Significant – Monitor Closely (0).\",\n" +
            "                \"side_effects\": \"Signs of an allergic reaction, like rash; hives; itching; red, swollen, blistered, or peeling skin with or without fever; wheezing; tightness in the chest or throat; trouble breathing, swallowing, or talking; unusual hoarseness; or swelling of the mouth, face, lips, tongue, or throat, trouble swallowing, Stomach pain, bloating, stomach cramps.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Onset: 12-72hr. Metabolism: not absorbed from GI tract. Mechanism of action Bulk-producing laxative.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Lactation: no data available; not absorbed, therefore it is unlikely to pose the risk in breast-feeding.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 8,\n" +
            "                  \"name\": \"1 powder\",\n" +
            "                  \"description\": \"660 mg\",\n" +
            "                  \"cost\": \"229 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 9,\n" +
            "                \"name\": \"Laxiquuill\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://www.rosheta.com/upload/69bfbd4f500137a48aeac3003e81d1cbd5f35f8d0ad75222c4c1b1035b4f99be.jpg\",\n" +
            "                \"composition\": \"psyllium 62%\",\n" +
            "                \"dose\": \"adult: 1-2 sachets PO qD-BID; place granules on tongue & swallow with 250mL of water. Pediatric: >12 years old: same as adult dose, >12 years old: not established.\",\n" +
            "                \"indication\": \"constipation\",\n" +
            "                \"contraindications\": \"Hypersensitivity, obstruction, fetal impaction, symptoms of appendicitis or acute surgical abdomen, GI ulceration, dysphagia, rectal bleeding.\",\n" +
            "                \"precautions\": \"Cautions: ingest adequate quantities of water with the preparation. Not recommended during abd pain, N/V, fever. Separate by all other medications by 2hr, since laxatives may decr absorption.\",\n" +
            "                \"interactions\": \"contraindicated (0), serious- Use Alternative (0), Significant – Monitor Closely (0).\",\n" +
            "                \"side_effects\": \"frequency not defined constipation, flatulence, abdominal cramping, impaction.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Onset: 12-72hr. Metabolism: not absorbed from GI tract. Mechanism of action Bulk-producing laxative.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Lactation: no data available; not absorbed; therefore, unlikely to pose risk in breast-feeding.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 9,\n" +
            "                  \"name\": \"6 sach\",\n" +
            "                  \"description\": \"\",\n" +
            "                  \"cost\": \"11 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },";


    private String drug2 = " {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 10,\n" +
            "                \"name\": \"Laxin\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://pharmacia1.com/wp-content/uploads/2015/11/%D9%84%D8%A7%D9%83%D8%B3%D9%8A%D9%86-%D8%A3%D9%82%D8%B1%D8%A7%D8%B5.jpg\",\n" +
            "                \"composition\": \"bisacodyl 10mg\",\n" +
            "                \"dose\": \"Adult: 5-15mg PO once daily; if complete evacuation required, 30mg PO once daily. Pediatric: <6 years: PO administration not recommended, because of requirement to swallow tablets, 6-12 years: 5mg or 0.3mg/kg PO at bedtime or before breakfast, >12 years: 2-15mh PO at bedtime.\",\n" +
            "                \"indication\": \"constipation\",\n" +
            "                \"contraindications\": \"hypersensitivity: obstruction or severe impaction. Symptoms of appendicitis or acute surgical abdomen, vomiting, rectal bleeding.\",\n" +
            "                \"precautions\": \"cautions: avoid chronic use; may cause laxative dependence. Avoid using in patients with gastroenteritis. Do not chew tablet; swallow whole. Not recommended for children <6 years because of requirement of swallow tablets. Not to be used for >1 week.\",\n" +
            "                \"interactions\": \"contraindicated (0). Serios – Use Alternative (2), sodium sulfate/potassium sulfate/magnesium sulfate, sodium sulfate/potassium sulfate/magnesium sulfate/polyethylene glycol.\",\n" +
            "                \"side_effects\": \"Frequency not defined abdominal cramping, Electrolyte and fluid imbalance, Excessive diarrhea, nausea, rectal burning, vertigo, vomiting.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of action: irritates smooth muscle of intestine and possibly colonic intramural plexus, thus in turn increasing peristalsis. Increases intestinal fluid accumulation and laxation by altering water and electrolyte secretion. Absorption: onset:6-10hr. Distribution:Vd:289L. Elimination: Half-life; 8hr.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Lactation: has not been detected in exerted milk; use with caution\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 10,\n" +
            "                  \"name\": \"20 Tablets\",\n" +
            "                  \"description\": \"10 mg\",\n" +
            "                  \"cost\": \"3.3 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 11,\n" +
            "                \"name\": \"Constacodyl\",\n" +
            "                \"rate\": \"4\",\n" +
            "                \"image\": \"https://pharmapedia.pw/wp-content/uploads/-%D9%84%D8%A7%D9%83%D8%B3%D9%8A%D9%86-e1552086327496.jpg\",\n" +
            "                \"composition\": \"Bisacodyl 5mg\",\n" +
            "                \"dose\": \"adult: 2-15mg PO once daily; if complete evacuation required, 30mg PO once daily. Pediatric: <6 years: PO administration not recommended, because of requirement to swallow tablets, 6-12years: 5mg or 0.3mg/kg PO at bedtime or before breakfast, >12years: 5-15mg PO at bedtime.\",\n" +
            "                \"indication\": \"constipation\",\n" +
            "                \"contraindications\": \"Hypersensitivity: Obstruction or severe impaction. Symptoms of appendicitis or acute surgical abdomen, vomiting, rectal bleeding.\",\n" +
            "                \"precautions\": \"Caution: Avoid chronic use; may cause laxative dependence. Avoid using in patients with gastroenteritis. Do not chew tablet; swallow whole. Not for use within 1hr of taking antacid or milk. Not recommended for children <6 years because of requirement to swallow tablets. Bot to be used for >1 week.\",\n" +
            "                \"interactions\": \"contraindicated (0). Serios – Use Alternative (2), sodium sulfate/potassium sulfate/magnesium sulfate, sodium sulfate/potassium sulfate/magnesium sulfate/polyethylene glycol.\",\n" +
            "                \"side_effects\": \"Frequency not defined abdominal cramping, Electrolyte and fluid imbalance, Excessive diarrhea, nausea, rectal burning, vertigo, vomiting.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of action: irritates smooth muscle of intestine and possibly colonic intramural plexus, thus in turn increasing peristalsis. Increases intestinal fluid accumulation and laxation by altering water and electrolyte secretion. Absorption: Onset:6-10hr. Distribution: Vd: 289L. elimination: Half-life:8hr.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"lactation: has not been detected in excreted milk; use with caution.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 11,\n" +
            "                  \"name\": \"10 Tablets\",\n" +
            "                  \"description\": \"5 mg\",\n" +
            "                  \"cost\": \"2.25 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 12,\n" +
            "                \"name\": \"Glucerin supp & Adt\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://images-eu.ssl-images-amazon.com/images/I/31AdtzKJLTL._SR600%2C315_PIWhiteStrip%2CBottomLeft%2C0%2C35_SCLZZZZZZZ_.jpg\",\n" +
            "                \"composition\": \"Each suppository contains 0.7359gm or 1.47gm of Glycerin.\",\n" +
            "                \"dose\": \"Glycerin adult suppositories, adult and children 6 years of age and older: one suppository or as directed by a doctor. Insert one suppository fully into the rectum. The suppository infantile suppositories, children 2 to under 6 years: one suppository or as directed by a doctor. Children under 2 years: consult a physician. Insert suppository fully into the rectum. The suppository need not melt completely to produce laxative action.\",\n" +
            "                \"indication\": \"these product are used for fast, predictable relief of occasional constipation.\",\n" +
            "                \"contraindications\": \"GI obstruction, severe impaction.\",\n" +
            "                \"precautions\": \": this product may cause rectal discomfort or a burning sensation. If you notice a sudden change in bowel habits that persists over a period of 2 weeks, consult a physician.\",\n" +
            "                \"interactions\": \"not reported\",\n" +
            "                \"side_effects\": \"rectal irritation may occur with its use.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Glycerin is hyperosmotic laxative, given rectally, which usually produces a bowel movement within 15min to 1hr. hyperosmotic laxative, encourage bowel movements by drawing water into the bowel from surrounding tissues. This produces a softer stool mass and increased bowel action.\",\n" +
            "                \"packaging\": \"Glycerin infantile suppository carton box contain 10 suppositories. Glycerin adult suppository carbon box contain 10 suppositories.\",\n" +
            "                \"pregnancy\": \"Lactation, not known whether excreted in breast milk; no risks shown to nursing infants.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 12,\n" +
            "                  \"name\": \"5 supp pharco ad\",\n" +
            "                  \"description\": \"1.4 g\",\n" +
            "                  \"cost\": \"5.25 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 13,\n" +
            "                \"name\": \"Acia\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"\",\n" +
            "                \"composition\": \"acia ext 1000mg\",\n" +
            "                \"dose\": \"Acia berries: no typical dosage; eaten as food, anthocyanin/ flavonoid therapeutic dosage (applicable to Acia berry): 200-1500mg qDay. Acia Berry Oil< skin ulcers, fever. Acia berry juice: if tolerated well, drink as needed, Acai berry extract 500mg qDay.\",\n" +
            "                \"indication\": \": “Adaptogen:” adapt to internal/ external stressors, fight fatigue, increase stamina. Traditional use: anti-aging; heart, bone/ joint & prostate/ urinary tract health; hypercholesterolemia; cleansing; inflammation. Diarrhea, fever, skin ulcers. Potent antioxidant (high ORAC [oxygen radical absorbance capacity] value) promoting natural defense against free radical infection & disease. Maintains healthy HDL cholesterol levels, improve blood circulation and reduce the risk of arteriosclerosis, stroke and heart attack. COX-1 and COX-2 inhibitor activity. May benefits as vasodilator in treatment of cardiovascular disease.\",\n" +
            "                \"contraindications\": \"not reported\",\n" +
            "                \"precautions\": \"Possibly Lupus.\",\n" +
            "                \"interactions\": \"not reported\",\n" +
            "                \"side_effects\": \"not reported\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Metabolism: N/A, Excretion N/A, Mechanism of action N/A.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: N/A, Lactation: N/A\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 13,\n" +
            "                  \"name\": \"90 caps\",\n" +
            "                  \"description\": \"1000 mg\",\n" +
            "                  \"cost\": \"149.5 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 14,\n" +
            "                \"name\": \"Activin\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://www.nippongenetics.eu/wp-content/uploads/2019/04/Activin-A.jpg\",\n" +
            "                \"composition\": \"grape seed extract 50mg \",\n" +
            "                \"dose\": \"Chronic Venous Insufficiency, Extract procyanidin: 150-300mg PO qD. Tablets/Capsules: 75-300mg/d for 3 weeks, then 40-80mg/d OR 360mg or 720mg once daily (Antistax, Boehringer Ingelheim) PO qD. Ocular Stress Reduction, Ectract procyanidin: 200-300mg PO qD. Other information: Endometriosis (based on RCT): 30mg PO BID.\",\n" +
            "                \"indication\": \"Atherosclerosis, attention deficit disorder, cancer (prevention), chronic venous insufficiency, collagen breakdown (prevention), dental caries prevention, macular degeneration, peripheral vascular disease, poor night vision, retinopathy, varicose veins, endometriosis. Efficacy: Effective in relieving symptoms of circulatory disorders. One RCT indicates effective in reducing symptoms of endometriosis (Kohama, J.Reprod Med). Not effective against signs of aging, collagen destruction.\",\n" +
            "                \"contraindications\": \"None reported\",\n" +
            "                \"precautions\": \"None reported\",\n" +
            "                \"interactions\": \"not reported\",\n" +
            "                \"side_effects\": \"Frequency Not Defined, Not reposted. Potential for hepatotoxicity.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Metabolism: N/A. Excretion: N/A. Mechanism of Action: Proathocyanidins: antioxidants.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: N/A. Lactation: N/A.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 14,\n" +
            "                  \"name\": \"20 taps\",\n" +
            "                  \"description\": \"50 mg\",\n" +
            "                  \"cost\": \"19.5 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 15,\n" +
            "                \"name\": \"Wheat derm\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://cf5.s3.souqcdn.com/item/2015/07/13/86/36/46/3/item_L_8636463_8589178.jpg\",\n" +
            "                \"composition\": \"wheat germ 500mg\",\n" +
            "                \"dose\": \"9g PO qDay. >90kg: 9g PO BID. Administration: mix powder in 150ml water ot other liquid not contain vitamin C. take 1 hour before meals.\",\n" +
            "                \"indication\": \"certain cancers, esp colorectal. Efficacy: Small clinical trails showed significant improvement in progression-free & overall survival (Br J Cancer 89, 465-469: 2003) & absence of metastases (Hepato-Gastroenterology 47, 393-395: 2000) in colorectal cancer patients compared to control groups. Other studies indicate survival benefits in melanoma & quality of life improvement in breast cancer. Approved in Hungary as a medical nutriment. \",\n" +
            "                \"contraindications\": \"pregnancy, lactation. Malabsorption syndrome, GI ulcers, celiac sprue, gluten sensitivity. Patients undergoing transplants. Inherited fructose intolerance. Hypersensitivity. \",\n" +
            "                \"precautions\": \"give only when patient has been able to take food orally without complications for at least 4 days. Give other medical products or supplements at least 2hr apart (esp vitamin C).\",\n" +
            "                \"interactions\": \"contraindicated (0), Serios-use alternative (0), significant-Monitor closely(2), ascorbic acid, rose hips, Minor(1), tamoxifen.\",\n" +
            "                \"side_effects\": \"Soft stools, nausea, diarrhea.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Metabolism: N/A. Excretion: N/A. Mechanism of Action, induces apoptosis in cancer cells; also immunostimulatory & hematopoietic effects.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: avoid. Lactation: avoid.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 15,\n" +
            "                  \"name\": \"20 caps\",\n" +
            "                  \"description\": \"500 mg\",\n" +
            "                  \"cost\": \"34.25 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 16,\n" +
            "                \"name\": \"Xeloda\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://breastcancer-news.com/wp-content/uploads/2016/03/Capecitabine-Xeloda.jpg\",\n" +
            "                \"composition\": \"capecitabine 500mg\",\n" +
            "                \"dose\": \"Adult; Duke Stage C Colon Cancer Adjuvant therapy. 1,250 mg/m2 PO BID x 2 weeks, followed by 1-week rest period, given as 3-week cycles for a total of 8 cycles (24 weeks), Colorectal Cancer Metastatic disease, 1250 mg/m^2 BID for 2 weeks q21 days. Breast Cancer Metastatic, resistant to paclitaxel, anthracyclines. MonotheraPY:1250 mg/m2 BID for 2 weeks q3Weeks. Combo therapy with Docetaxe1:1250 m5 PO BID for 2 weeks q3 Weeks plus docetaxel 75 mg/m5 1 hour IV infusion q3Weeks. Administration Swallow with water within 30 min after a meal. Dosage may need to be individualized to optimize patient management. Dose Modifications Renal impairment CrCI 30-50 mL/min Reduce dose by 2596 CrCI <30 mL/min: Contraindicated, pediatric: safety & efficacy not established.\",\n" +
            "                \"indication\": \"Duke Stage C, Colon Cancer, Colorectal Cancer, Breast Cancer.\",\n" +
            "                \"contraindications\": \"Hypersensitivity to capecitabine or fluorouracil (5- FU) . Severe renal impairment (CPU <30mL/min)\",\n" +
            "                \"precautions\": \"Cautions May result in bleeding, death; monitor anticoagulant response (e.g., IN R) and adjust anticoagulant dose accordingly, Diarrhea may be severe; interrupt capecitabine treatment immediately until diarrhea resolves or decreases to grade 1, recommend standard antidiarrheal treatments. Cardiotoxicity is common in patients with a prior history of coronary artery disease. Increased risk of severe or fatal adverse reactions in patients with low or absent dihydropyrimidine dehydrogenase (DPD) activity; withhold or permanently discontinue capecitabine in patients with evidence of acute early-onset or unusually severe toxicity, which may indicate near complete or total absence of DPD activity; no capecitabine dose has been proven safe in patients with absent DOD activity. Interrupt capecitabine treatment until dehydration is corrected; potential risk of acute renal failure secondary to dehydration; monitor and correct dehydration. Can cause fetal harm; advise women of the potential risk to the fetus. Severe mucocutaneous reactions, Steven-Johnson Syndrome (SJS) and Toxic Epidermal Necrolysis (TEN), reported; discontinue therapy in patients who experience a severe mucocutaneous reaction during treatment; capecitabine may induce hand-and-foot syndrome; interrupt capecitabine treatment until hand-and-foot syndrome event resolves or decreases in intensity. If hyperglirubinemia occurs, interrupt therapy immediately until it resolves or decreases in intensity. Do not treat patients with neutrophil counts <1.S 10A9;PL or thrombocyte counts <100 xl0A9;PL.; if grade 3-4 neutropenia or thrombocytopenia occurs, stop therapy until condition resolves. Black Box Warnings Capecitabine may increase the anticoagulant effects of warfarin increasing the INR several days up to several months after initiating capecita bine or within one month after stopping the therapy. Risk factors include >60 years of age and cancer. Monitor closely\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (6) adenovirus types 4 and 7 live, oral enoxaparin influenza virus vaccine trivalent, adjuvanted palifermin tofacitinib warfarin. Side Effects: Varies with carcinoma type 10. Diarrhea Nausea Anemia LymphoPenia Hand and foot syndrome Edema Fatigue Fever Headache Pain Paresthesia Alopecia Dermatitis Abdominal pain Anorexia. Pharmacology: Pharmacology Half-life: 0.75 hr Peak Plasma TiMe:1.5 hr Protein Bound: .6096 Metabolism: hepatic Metabolites:5.-DFUR Excretion: urine (959.6) Dialyzable: yes  Pharmacogenomics Dihydropyrimidine dehydrogenase (DPD), an enryme encoded by the DPYD gene, is the rate-limiting step in pyrimidine catabolism and deactivates >BO% of 5FU standard doses and the 5FL, prodrug capecitabine. Contraindicated in patients with DPD deficiency, causes severe toxicity with conventional doses (le, grade III/IV toxicity and potentially fatal neutropenia, mucositis, and diarrhea). Because true DOD deficiency is rare and because the clinical implications of partial deficiency are still unclear, screening for mutations prior to initiating therapy is not warranted.\",\n" +
            "                \"side_effects\": \"not reported\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"not reported\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: D, Lactation: excretion in milk unknown/not recommended\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 16,\n" +
            "                  \"name\": \"120 taps\",\n" +
            "                  \"description\": \"500 mg\",\n" +
            "                  \"cost\": \"2730 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 17,\n" +
            "                \"name\": \"Litak\",\n" +
            "                \"rate\": \"4\",\n" +
            "                \"image\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaSHZ72mrupzZeKcm70VwoQhDJ1DRlr7P9U-SR93zJyBsiXOnl&s\",\n" +
            "                \"composition\": \"cladribine 10mg\",\n" +
            "                \"dose\": \"Adult: Hairy Cell Leukemia 0.00 mg/kg/day IV for? days continuous infusion; may repeat q28-35Days Monitor:03C, chemistries. Pediatric Safety and efficacy not established.\",\n" +
            "                \"indication\": \"Hairy Cell Leukemia Multiple Sclerosis Non-Hodgkin Lymphoma Acute Myeloid Leukemia Chronic Lyrnphccytic Leukemia. Other indications 8 Uses Off-label: Cutaneous ',cell lymphoma, AML CLL, NHL, autoimmune hemolytic anemia, mycosis fungoid, Sezary syndrome\",\n" +
            "                \"contraindications\": \"Hypersensitivity\",\n" +
            "                \"precautions\": \"Cautions Hepatic/renal impairment. Allopurinol and IV hydration recommended for patients with high tumor burden to prevent tumor lysis syndrome. Avoid pregnancy. May impair fertility; shown to suppress rapidly generating cells, including testicular cells. Do not administer live virus vaccines, risk of infection in setting of immunosuppression. Black Box Warnings The drug should be administered under the supervision of an experienced cancer chemotherapy physician. Bone marrow suppression may occur but is usually reversible and appears to be dose dependent. Continuous infusion of high doses of 4 to 9 times the recommended dose for hairy cell leukemia has been associated with serious acute nephrotoxicity and neurological toxicity resulting in irreversible paraparesis and guadraparesis. Standard cladribine dosing regimens have also been associated with severe neurological toxicity.\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (3) adenovirus types 4 and 7 live, oral palifermin tofacitinib.\",\n" +
            "                \"side_effects\": \"not reported\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of Action Purine analog, impairs DNA repair. Pharmacokinetics Half-Life: 5.4hr. Protein bound:20% Vd:4.5 LAO Clearance: 978ml/hr/kg Excretion: urine.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category, D, Lactation: not known if excreted in breast milk, do not nurse.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 17,\n" +
            "                  \"name\": \"1 vail\",\n" +
            "                  \"description\": \"10 mg\",\n" +
            "                  \"cost\": \"55440\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 18,\n" +
            "                \"name\": \"Cytosar\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://www.almrsal.com/wp-content/uploads/2016/12/CYTOSAR-VIAL.png\",\n" +
            "                \"composition\": \"cytarabine 100mg\",\n" +
            "                \"dose\": \"Adult: Acute Nonlymphocytic Leukemia IV administration for remission induction 100-200 mg/sq.meter/day for 5-10 days; begin second course in 2-4 weeks after initial therapy if necessary OR 100 mg/sq.meter for? days OR 100 mg/sq.meter/dose q12hr for 7 days. IT administration for remission induction 5-75 mg/sq.meter q2-7Days until CNS findings normalize. IV administration for remission maintenance 70-200 mg/sq.meter/dayfor 2-5 days at monthly intervals. IM administration for remission maintenance 1-1.5 mg/kg single dose for maintenance at 1- 4 week intervals. Meningea I Leukemia IT administration 30 mg/sq.meterintrathecal (IT) q4Days until CSF findings normal plus one additional dose. Refractory Leukemia IV administration 3 g/sq.meter IV (infusion over 1-3 hours) ql2hr x 4-12 doses Repeat q2-3Weeks.\",\n" +
            "                \"indication\": \"Acute Nonlymphocytic Leukemia Meningea I Leukemia Refractory Leukemia Lymphomatous Meningitis (DepoCyt) Gliomas. Other Indications& Uses Conventional: ALL, AML. NHL Liposomai\",\n" +
            "                \"contraindications\": \"Hypersensitivity. Liposomal cytarabine: active meningeal infection.\",\n" +
            "                \"precautions\": \": Cautions Potent bone marrow suppression Severe and at times fatal CNIS, GI, and pulmonary toxicity, Cardiomyopathy with subsequent death reported following experimental high dose therapy with cytarabine in combination with cyclophosphamide when used for bone marrow transplant preparation. Do not use benzyl alcohol-containing solutions IT or in neonates. Avoid pregnancy , Liposoe! IT administrations flow assessment should be considered before treatment is started Blockage to CSF flow may increase risk of neurotoxicity due to increased serum concentrations Toed uce incidence of arachnoiditis, administer dexa methadone concurrently Hydrocephalus has also been reported, possibly precipitated by arachnoiditis Infectious meningitis may be associated with IT drug administration. Following nr administration, CNS toxicity, including persistent extreme somnolence, hemiplegia, visual disturbances including blindness which may be total and permanent, deafness, cranial nerve palsies, and visual disturbances including blindness which may be total and permanent, have been reported Symptoms and signs of peripheral neuropathy (eg, pain, numbness, paresthesia, weakness, impaired bowel and bladder control) observed; in some cases, these signs and symptoms have been reported as Cauda Equine Syndrome. Black Box Warnings Conventional formulation Only physicians experienced in cancer chemotherapy should administer For induction therapy, administer in facility with lab and supportive resources sufficient to monitor drug tolerance and protect and maintain patient if compromised by drug toxicity. Main toxic effect is bone marrow suppression with leukopenia, thrombocytopenia, and anemia Less serious toxicity includes nausea, vomiting, diarrhea, abdominal pain, oral ulceration, and hepatic dysfunction. Arachnoiditis with liposornal IT administration In all clinical studies, chemical arachnoiditis, a syndrome manifested primarily by nausea, vomiting, headache and fever, was a common adverse event.\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (4) adenovirus types 4 and 7 live, oral influenza virus vaccine trivalent, adjuvanted palifermin tofacitinib.\",\n" +
            "                \"side_effects\": \"1-10%  Anorexia, Nausea Vomiting Diarrhea OraVanal inflammation Thrombophlebitis Bleeding Myelosuppression Rash Fever Hepatic dysfunction Frequency Not Defined Headache Neuropathy Chest pain Pericarditis Pneumonia.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of Action Metabolite cytarabine-5'-triphosphate inhibits DNA polymerase during 5 phase, Absorption Systemic Exposure after IT: negligible Peak Plasma Time: 20-60 min Peak CSF Time (IT), 60 min Peak CSF Concentration (IT): 30-50 mcg/mL. Distribution Protein Bound:13%. Metabolism: liver (major), kidneys (minor); neglible following IT administration. Metabolites: cytarabine-5-triphosphate (ara-CTP). Elimination Half-Life:1-3hr. Half-Life (CST after In: 5.9-82.4hr CSF clearance rate:0.24 mL/min Excretion: urine.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category D, Lactation: not known if excreted in breast milk, avoid.\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 18,\n" +
            "                  \"name\": \"amp\",\n" +
            "                  \"description\": \"100 mg\",\n" +
            "                  \"cost\": \"17 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 19,\n" +
            "                \"name\": \"Tabine\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://blog.rosheta.com/wp-content/uploads/2019/07/Tabine.gif\",\n" +
            "                \"composition\": \"cytarabine 100mg\",\n" +
            "                \"dose\": \"Adult: Acute Nonlymphocytic Leukemia IV administration for remission induction 100-200 mg/sq.meter/day for 5-10 days; begin second course in 2-4 weeks after initial therapy if necessary OR 100 mg/sq.meter for? days OR 100 mg/sq.meter/dose q12hr for 7 days. IT administration for remission induction 5-75 mg/sq.meter q2-7Days until CNS findings normalize. IV administration for remission maintenance 70-200 mg/sq.meter/dayfor 2-5 days at monthly intervals. IM administration for remission maintenance 1-1.5 mg/kg single dose for maintenance at 1- 4 week intervals. Meningea I Leukemia IT administration 30 mg/sq.meterintrathecal (IT) q4Days until CSF findings normal plus one additional dose. Refractory Leukemia IV administration 3 g/sq.meter IV (infusion over 1-3 hours) ql2hr x 4-12 doses Repeat q2-3Weeks, Lymphomatous Meningitis (DepoCyt) IT liposornal administration IT by intraventricular or lumbar puncture Induction:50 mg ql4Days weeks 1 and 3 (2 doses total) Consolidation: 50 mg ql4Days (weeks 5, 7,9) and an additional dose on week 13 Maintenance: SO mg q2EIDays for 4 doses (weeks 17,21,25, and 29). Administration Allopurinol P. IV hydration recommended for patients at risk of tumor lysis syndrome. IT: Patient should lie flat for 1 hour after lumbar puncture. Liposomal: To reduce incidence of arachnoiditis, administer dexamethasone concurrently. Monitor CDC, LFTs, renal function. Suspend prescription if platelets s50,000/cu.mm or PM Ns <1000/cu.mm. Pediatric: Conventional As in adults. Liposomal Not recommended. Indications: Acute Nonlymphocytic Leukemia Meningea I Leukemia Refractory Leukemia Lymphomatous Meningitis (DepoCyt) Gliomas. Other Indications& Uses Conventional: ALL, AML. NHL Liposomai\",\n" +
            "                \"indication\": \"not reported\",\n" +
            "                \"contraindications\": \"Hypersensitivity. Liposomal cytarabine: active meningeal infection.\",\n" +
            "                \"precautions\": \"Cautions Potent bone marrow suppression. Severe and at times fatal CBS, GI, and pulmonoary toxicity Cardiomyopathy with subsequent death reported following experimental high dose therapy with cytarabine in combination with cyclophosphamide when used for bone marrow transplant preparation. Do not use benryl alcohol-containing solutions IT or in neonates. Avoid pregnancy. Liposome! IT administration CSF flow assessment should be considered before treatment is started Blockage to CSF flow may increase risk of neurotoxicity due to increased serum concentrations To reduce incidence of arachnoiditis, administer dent methadone concurrently Hydrocephalus has also been reported, possibly precipitated by arachnoiditis Infectious meningitis may be associated with IT drug administration. Following nr administration, CNS toxicity, including persistent extreme somnolence, hemiplegia, visual disturbances including blindness which may be total and permanent, deafness, cranial nerve palsies, and visual disturbances including blindness which may be total and permanent, have been reported Symptoms and signs of peripheral neuropathy leg, pain, numbness, paresthesia, weakness, impaired bowel and bladder control) observed; in some cases, these signs and symptoms have been reported as Cauda Equine Syndrome. Black Box Warnings Conventional formulation Only physicians experienced in cancer chemotherapy should administer For induction therapy, administer in facility with lab and supportive resources sufficient to monitor drug tolerance and protect and maintain patient if compromised by drug toxicity. Main toxic effect is bone marrow suppression with leukopenia, thrombocytopenia, and anemia Less serious toxicity includes nausea, vomiting, diarrhea, abdominal pain, oral ulceration, and hepatic dysfunction. Arachnoiditis with liposornal IT administration In all clinical studies, chemical arachnoiditis, a syndrome manifested primarily by nausea, vomiting, headache and fever, was a common adverse event.\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (4) adenovirus types 4 and 7 live, oral influenza virus vaccine trivalent, adjuvanted palifermin tofacitinib\",\n" +
            "                \"side_effects\": \"1-10% Anorexia, Nausea Vomiting Diarrhea Oral/anal inflammation Thrombophlebitis Bleeding Myelosuppression Rash Fever Hepatic dysfunction Frequency Not Defined Headache Neuropathy Chest pain Pericarditis\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \": Mechanism of Action Metabolite cytarabine-5'-triphosphate inhibits DNA polymerase during 5 phase. Absorption Systemic Exposure after IT: negligible Peak Plasma Time: 20-60 min Peak CSF Time (11:60 min Peak CSF Concentration (IT): 30-50 mcg/mL Distribution Protein Bound:13%. Metabolism: liver (major), kidneys (minor); neglible following IT administration. Metabolites: cytarabine-5-triphosphate (ara-CTP). Elimination Half-Life:1-3 hr. Half-Life (CST after Cr):5.9-82.4 hr C5F clearance rate:0.24 mL/min Excretion: urine.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category D, Lactation: not known if excreted in breast milk, avoid\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 19,\n" +
            "                  \"name\": \"1 vail\",\n" +
            "                  \"description\": \"100 mg\",\n" +
            "                  \"cost\": \"80 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },";

    private String drug3 = "{\n" +
            "              \"category\":1,\n" +
            "                \"id\": 20,\n" +
            "                \"name\": \"5 Fluoro uracil\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://5.imimg.com/data5/XC/WO/ZI/SELLER-3005753/fluorouracil-500x500.jpg\",\n" +
            "                \"composition\": \"fluorouracil 250mg\",\n" +
            "                \"dose\": \"Adult: Cancers of Colon, Breast, Ovary, Liver, Pancreas, Rectum, Stomach Various protocols exist 500mg/sq.meter IV on Days 1-5, OR 450-600 mg/sq.meter IV weekly, OR 200-400 mg/sq.meter IV continuous infusion qD Not to exceed 800 mg/day. Other Information May use leucovorin concomitantly, Monitor: CBC\",\n" +
            "                \"indication\": \"Cancers of Colon, Breast, Ovary, Liver, Pancreas, Rectum, Stomach Glioblastoma Multiforme (Orphan) Advanced Colorectal Carcinoma (Orphan) Esophageal Carcinoma (Orphan), Other Indications & Uses Off-label use for cervical, bladder, hepatic, prostate, endometrial, and head and neck carcinoma.\",\n" +
            "                \"contraindications\": \"Hypersensitivity Poor nutritional status Myelosuppression Serious infection Recent serious surgery. Dihydropyrimidine Dehydrogenase (C/P171) deficiency.\",\n" +
            "                \"precautions\": \"Cautions Discontinue in case of stomatitis, esophagopharyngitis, leukopenia, thrombocytopenia, intractable vomiting, GI bleeding, hemorrhage, diarrhea. Prior allvlating agent use, CAD, hepatic/renal impairment, Avoid pregnancy. Black Box Warnings The drug should be administered under the supervision of an experienced cancer chemotherapy physician because of the possibility of severe toxic reactions. Patient should be hospitalized for initiation of the therapy because of the risk for severe toxic reactions.\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (5) adenovirus types 4 and 7 live, oral germanium influenza virus vaccine trivalent, adjuvanted palifermin totacitinib.\",\n" +
            "                \"side_effects\": \"1-10% Loss of appetite, Headache Nausea Vomiting Diarrhea Mucositis Myelosuppression Alopecia Photosensitivity Hand-foot syndrome Maculopapular eruption (pruritic) Frequency Not Defined Angina Coronary Arteriosclerosis Thrombophlebitis Darkening of veins.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Pharmacology Half-Life,16 min. Onset: 2-7 d, but may take up to 12 wk Duration:24 hr Metabolism: liver. Metabolites: urea, fluorouracil, dihydrofluorouracil, expired CO2 metabolite. Excretion: urine, Pharmacogenomics Dihydropyrimidine dehydrogenase (DPD), an enzyme encoded by the DP,/ gene, is the rate-limiting step in pyrimidine catabolism and deactivates >80% of SPLI standard doses and the 5F1_, prodrug capecitabine, Contraindicated in patients with DPD deficiency: causes severe toxicity with conventional doses lie, grade 111/1V toxicity and potentially fatal neutropenia, mucositis, and diarrhea). Because true DPD deficiency is rare and because the clinical implications of partial deficiency are sbll unclear, screening for mutations prior to initiating therapy is not warranted. Genetic testing laboratories The following companies currently offer testing.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: D. Lactation: excretion in milk unknown; do not nurse\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 20,\n" +
            "                  \"name\": \"10 amp\",\n" +
            "                  \"description\": \"250 mg\",\n" +
            "                  \"cost\": \"80 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 21,\n" +
            "                \"name\": \"Efudix\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://www.dockpharmacy.com/wp-content/uploads/2018/07/efudix-cream-40g.jpg\",\n" +
            "                \"composition\": \"fluorouracil 5%\",\n" +
            "                \"dose\": \"Adult: Cancers of Colon, Breast, Ovary, Liver, Pancreas, Rectum, Stomach Various protocols exist. 500 mg/sq.meter IV on Days 1-S, OR 450-600 mg/sq.meter IV weekly, OR 200-400 mg/sq.meter IV continuous infusion qD Not to exceed 800 mg/day. Other Information May use leucovorin concomitantly. Monitor: CBC\",\n" +
            "                \"indication\": \"Cancers of Colon, Breast, Ovary, Liver, Pancreas, Rectum, Stomach Glioblastoma Multiforme (Orphan) Advanced Colorectal Carcinoma (Orphan) Esophageal Carcinoma (Orphan). Other Indications & Uses Off-label use for cervical, bladder, hepatic, prostate, endometrial, and head and neck carcinoma.\",\n" +
            "                \"contraindications\": \"Hypersensitivity Poor nutritional status Myelosuppression Serious infection Recent serious surgery Di hydropyrimidine Dehydrogenase (DP D) deficiency\",\n" +
            "                \"precautions\": \"Cautions Discontinue in case of stomatitis, esophagopharyngitis, leukopenia, thrombocytopenia, intractable vomiting, GI bleeding, hemorrhage, diarrhea, Prior allvlating agent use, CAD, hepatic/renal impairment, Avoid pregnancy, Black Box Warnings The drug should be administered under the supervision of an experienced cancer chemotherapy physician because of the possibility of severe toxic reactions. Patient should be hospitalized for initiation of the therapy because of the risk for severe toxic reactions.\",\n" +
            "                \"interactions\": \"Serious - Use Alternative (5) adenovirus types 4 and 7 live, oral germanium influenza virus vaccine trivalent, adjuvanted palifermin totacitinib\",\n" +
            "                \"side_effects\": \"1-10% Loss of appetite Headache Nausea Vomiting Diarrhea Mucositis Myelosuppression Alopecia Photosensitivity Hand-foot syndrome Maculopapular eruption (pruritic) Frequency Not Defined Angina Coronary arteriosclerosis Thrombophiebitis Darkening of veins Gastrointestinal ulcer\",\n" +
            "                \"overdose\": \"nor reported\",\n" +
            "                \"pharmacology\": \": Pharmacology, Half-Life:16 min. Onset:2-7 d, but may take up to 12wk Duration:24hr Metabolism: liver Metabolites: urea, fluorouracil, dihydrofluorouracil, expired CO2 metabolite Excretion: urine. Pharmacogenomics Di hydropyrimidine dehydrogenase (DOD), an enzyme encoded by the DPYD gene, is the rate-limiting step in pyrimidine catabolism and deactivates >B09fi of 5F1_, standard doses and the 5FU prodrug capecitabine, Contraindicated in patients with DPD deficiency, causes severe toxicity with conventional doses tie, grade 111/IV toxicity and potentially fatal neutropenia, mucositis, and diarrhea). Because true DPD deficiency is rare and because the clinical implications of partial deficiency are still unclear, screening for mutations prior to initiating therapy is not warranted. Genetic testing laboratories.\",\n" +
            "                \"packaging\": \"nor reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category: D. Lactation: excretion in milk unknown; do not nurse\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 21,\n" +
            "                  \"name\": \"1 cream\",\n" +
            "                  \"description\": \"\",\n" +
            "                  \"cost\": \"325 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 22,\n" +
            "                \"name\": \"Uft\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"\",\n" +
            "                \"composition\": \"tegafur 100mg, uracil 224\",\n" +
            "                \"dose\": \"Oral Malignant neoplasms Adult Up to 1 g/m2 daily. Usually used with uracil. Oral Advanced colorectal cancer Adult 300 mg/m2tegafur combined with 672 mg/m2 uraci I daily in 3 divided doses, together with calcium folinate. Doses are given for a cycle of 28 days, followed by 7 days without treatment. Intravenous Malignant neoplasms Adult 1-3 g/m2 daily for 5 days.\",\n" +
            "                \"indication\": \"Malignant neoplasms Advanced colorectal cancer\",\n" +
            "                \"contraindications\": \"Pregnancy, lactation. Hypersensitivity.\",\n" +
            "                \"precautions\": \"Special Precautions Weak or malnourished patients, hepatic and renal impairment, history of cardiac disease, acute infections. Determine blood count frequently.\",\n" +
            "                \"interactions\": \"Concurrent use increased risk of neurotoxicity with leflunomide, increased risk of phenytoin toxicity with phenytoin, increased anticoagulation effect of warfarin; increased risk of myelosupression with colony stimulating factors eg. filgrastim; increased risk of thrombosis with tamoxifen; increased risk of toxicity with folic acid.  Potentially Fatal: Increased risk of severe toxicity with sorivudine.\",\n" +
            "                \"side_effects\": \"Nausea, vomiting, anorexia, mucositis, malaise, hot flushes, oedema, itching, central neurotoxicity, bone-marrow depression, stomatitis, haemorrhage, skin rashes, alopoecia, ocular irritation, myocardial ischaemia.\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"not reported\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [\n" +
            "                  {\n" +
            "                  \"id\": 22,\n" +
            "                  \"name\": \"28cap\",\n" +
            "                  \"description\": \"100 mg\",\n" +
            "                  \"cost\": \"850 egp\"\n" +
            "                  }\n" +
            "                  ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"category\":1,\n" +
            "                \"id\": 23,\n" +
            "                \"name\": \"Hydrea\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://www.buyonlineventolin.com/63/hydrea-500-mg-100-capsules-ingredient-hydroxyurea.jpg\",\n" +
            "                \"composition\": \"hydroxyurea 500mg \",\n" +
            "                \"dose\": \"Adult: Solid Tumors Intermittent Therapy:80 mg/kg PO q3day, OR Continuous Therapy 20-30 mg/kg PO gDay. Head A. Neck Tumors Concomitant therapy with irradiation 80 mg/kg PO q3days Begin 7 days prior to initiation of irradiation Chronic Iviyelocytic Leukemia, Resistant Continuous Therapy 20-30 mg/kg PO gDay. Sickle Cell Disease Start 15 mg/kg/day as single dose; monitor patient's blood count every two weeks. Titrate by 5 mg/kg/clay q12wk. Dose is not increased if blood counts are between acceptable range and toxic. Not to exceed 35 mg/kg/day. Discontinue therapy until hematologic recovery if blood counts are considered toxic may resume treatment after reducing dose by 2.5 mg/kg/day from dose associated with hematological toxicity. Thrombocythemia, Essential 15 mg/kg PO gDay.\",\n" +
            "                \"indication\": \"Solid Tumors Head & Neck Tumors Chronic Myelocytic Leukemia, Resistant Sickle Cell Disease Tbrombocythemia, Essential HIV, Adjunct Treatment (Off-label) Psoriasis (Of(-label). Contraindications: Hypersensitivity Severe anemia, bone marrow depression WBC <2500/mm3, platelets <100,000/mm3 Pregnancy, lactation.\",\n" +
            "                \"contraindications\": \"not reported\",\n" +
            "                \"precautions\": \"Caution in renal impairment, coadministration with myelosuppressive agents. Leukopenia and neutropenia commonly occur; thrombocytopenia and anemia are less common; hematologic toxicity is reversible Do not change dose too frequently. Not recommended in sickle cell anemia if neutrophils <2,000/mm., platelets <80,000/mm3, hemoglobin <4 ski I_ or reticulocytes <80,000/ mm' when hemoglobin <9 g/c11_. Increased risk of hepatotoxicity, which may be fatal, may occur, particularly in combination with didanosine and stavudine. Risk of cutaneous vasculitic toxicities in patients with myeloproliferative disorders, especially with history of or concurrent interferon therapy. Discontinue if NBC 2500/mm3 and/or plateletes<100,000/mm, Erythrocyte abnormalities reported; self-limiting megaloblastic erythropoiesis reported early in treatment, unrelated to vitamin 612 or folic acid deficiency. Hyperuricemia may occur, adequate hydration, dosage adjustment, or initiation of uricosuric.\",\n" +
            "                \"interactions\": \"Contraindicated (is) adenovirus types 4 and 7 live, oral anthraxvaccine bcg intravesical live bcg vaccine live didanosine influenza virus vaccine quadrivalent, intranasal measles mumps and rubella vaccine, live measles, mumps, rubella and varicella vaccine, live poliovirus vaccine live oral trivalent rotavirus oral vaccine, live smallpox vaccine typhoid vaccine live varicella virus vaccine live yellow fever vaccine zoster vaccine live. Serious - Use Alternative (4) human papillomavirus vaccine, bivalent human papillomavirus vaccine, nonavalent human papillomavirus vaccine, quadrivalent tofacitinib.\",\n" +
            "                \"side_effects\": \"not reported\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of Action The precise mechanism by which hydroxyurea produces its cytotoxic and cytoreductive effects is not known. However, various studies support the hypothesis that hydroxyurea causes an immediate inhibition of DNA synthesis by acting as a ribonucleotide reductase inhibitor, without interfering with the synthesis of ribonucleic acid or of protein. The mechanisms by which hydroxyurea produces its beneficial effects in patients with sickle cell is (SCA) are uncertain. Known pharmacologic effects of hydroxyurea that may contribute to its beneficial effects include increasing hemoglobin F levels in red blood cells (RBCs), decreasing neutrophils, increasing the water content  of RBCs, increasing deformability of sickled cells, and altering the adhesion of RBCs to endothelium.  Absorption Duration: up to 24 hr Peak Plasma Time:1-4 hr. Distribution Vd:O.S Likg. Protein binding: 75-80%. Metabolism Metabolized (60%) by liver and GI tract.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"Pregnancy Category D. Lactation: excreted in breast milk, do not nurse\",\n" +
            "                \"tablets\": [    \n" +
            "                  {\n" +
            "                  \"id\": 23,\n" +
            "                  \"name\": \"100 caps\",\n" +
            "                  \"description\": \"500 mg\",\n" +
            "                  \"cost\":\"110 egp\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            },";

    private String drug4 = "{\n" +
            "              \"category\":2,\n" +
            "                \"id\": 24,\n" +
            "                \"name\": \"Glucobay\",\n" +
            "                \"rate\": \"4.5\",\n" +
            "                \"image\": \"https://tse1.mm.bing.net/th?id=OIP.WHYJkY3G27wKU5Q0VCUEpgHaHa&pid=Api&P=0&w=300&h=300\",\n" +
            "                \"composition\": \"LUCOBAY 50 tablets contain 50 mg acarbose GLUCOBAY 100 tablets contain 100 mg acarbose\",\n" +
            "                \n" +
            "                \"dose\": \"GLUCOBAY tablets are taken orally and should be chewed with the first mouthful of food, or swallowed whole with a little liquid directly before the meal. Owing to the great individual variation of glucosidase activity in the intestinal mucosa, there is no fixed dosage regimen, and patients should be treated according to clinical response and tolerance of intestinal side-effects. Adults: The recommended initial dose is 50 mg three times a day. If after six to eight weeks treatment patients show an inadequate clinical response, the dosage may be increased to 100 mg three times a day. A further increase in dosage to a maximum of 200 mg three times a day may occasionally be necessary. GLUCOBAY is intended for continuous long-term treatment. Elderly patients: No modification of the normal adult dosage regimen is necessary.\",\n" +
            "                \"indication\": \"GLUCOBAY is indicated for the treatment of non-insulin dependent diabetes mellitus (NIDDM) in patients inadequately controlled on diet alone, or on diet and oral hypoglycaemic agents.\",\n" +
            "                \"contraindications\": \"Known hypersensitivity to acarbose or any of the excipients, use in children less than 12 years of age, pregnancy and in nursing mothers. GLUCOBAY is also contra-indicated in patients with inflammatory bowel disease, colonic ulceration, partial intestinal obstruction or in patients predisposed to intestinal obstruction. In addition, GLUCOBAY should not be used in patients who have chronic intestinal diseases associated with marked disorders of digestion or absorption and in patients who suffer from states which may deteriorate as a result of increased gas formation in the intestine, (e.g. Roemheld’s syndrome [an angina pectoris-like syndrome or aggravation of an angina pectoris due to the post-prandial filling of the stomach] and larger hernias). GLUCOBAY is contra-indicated in patients with hepatic and severe renal impairment (creatinine clearance <25 mL/min/ 1,73m2).\",\n" +
            "                \"precautions\": \"Owing to its mode of action, GLUCOBAY results in a greater proportion of dietary carbohydrate being digested in the large bowel. This carbohydrate may also be utilised by the intestinal flora, resulting in the increased formation of intestinal gas. Flatulence, diarrhoea, abdominal pain, nausea, borborygmi and a feeling of fullness. Subileus/ileus may occur. If the prescribed diabetic diet is not adhered to the intestinal side effects may be intensified. If strongly distressing symptoms develop in spite of adherence to the diabetic diet prescribed, the doctor must be consulted and the dose temporarily or permanently reduced. The symptoms are both dose and dietary substrate related and may subside with continued treatment. Symptoms can be reduced by adherence to the prescribed diabetic diet and the avoidance of sucrose or foodstuffs containing sugar.\",\n" +
            "                \"interactions\": \"Interaction with Alcohol Description Consumption of alcohol may cause an increase or decrease in blood glucose levels. The mechanism involves inhibition of gluconeogenesis and the counter-regulatory response to hypoglycemia. Instructions Consumption of alcohol is not recommended in the patients with diabetes due to increase in the risk of altered blood glucose levels. Frequent monitoring of blood glucose levels is necessary and proper diet should be maintained for better diabetic control. Interaction with Medicine Aripiprazole Gatifloxacin Furosemide Corticosteroids Disease interactions Impaired liver function Glucobay 50 MG Tablet is not recommended in the patients with primary cirrhosis. Inform the doctor if you have a history of liver injury. An alternate medicine should be considered based on the clinical condition. Diabetic Ketoacidosis Glucobay 50 MG Tablet is not recommended in the patients with diabetic ketoacidosis. Inform the doctor if you have a history of diabetic ketoacidosis. An alternate medicine should be considered based on the clinical condition. Gastro-intestinal disease Glucobay 50 MG Tablet is not recommended in the patients with inflammatory bowel disease or any chronic intestinal disease. Inform the doctor if you are suffering from any gastrointestinal disease. An alternate medicine should be considered based on the clinical condition. Food interactions Information not available. Lab interactions Information not available.\",\n" +
            "                \"side_effects\": \"1)-Yellow colored eyes or skin 2)- Abdominal pain 3)- Diarrhea 4)- Flatulence 5)- Nausea or Vomiting\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"Mechanism of Action The precise mechanism by which hydroxyurea produces its cytotoxic and cytoreductive effects is not known. However, various studies support the hypothesis that hydroxyurea causes an immediate inhibition of DNA synthesis by acting as a ribonucleotide reductase inhibitor, without interfering with the synthesis of ribonucleic acid or of protein. The mechanisms by which hydroxyurea produces its beneficial effects in patients with sickle cell is (SCA) are uncertain. Known pharmacologic effects of hydroxyurea that may contribute to its beneficial effects include increasing hemoglobin F levels in red blood cells (RBCs), decreasing neutrophils, increasing the water content  of RBCs, increasing deformability of sickled cells, and altering the adhesion of RBCs to endothelium.  Absorption Duration: up to 24 hr Peak Plasma Time:1-4 hr. Distribution Vd:O.S Likg. Protein binding: 75-80%. Metabolism Metabolized (60%) by liver and GI tract.\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"1)- This medicine is not recommended for pregnant women. 2)- This medicine is not recommended in breastfeeding women.\",\n" +
            "                \"tablets\": [    \n" +
            "                  {\n" +
            "                  \"id\": 1,\n" +
            "                  \"name\": \"30 caps\",\n" +
            "                  \"description\": \"50mg\",\n" +
            "                  \"cost\":\"10 LE\"\n" +
            "                  },\n" +
            "                   {\n" +
            "                  \"id\": 2,\n" +
            "                  \"name\": \"30 caps\",\n" +
            "                  \"description\": \"100mg\",\n" +
            "                  \"cost\":\"36 LE\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            },\n" +
            "              {\n" +
            "              \"category\":2,\n" +
            "                \"id\": 25,\n" +
            "                \"name\": \"Onglyza\",\n" +
            "                \"rate\": \"4\",\n" +
            "                \"image\": \"http://www.liferelayhealthcare.com/wp-content/uploads/2015/05/onglyza-2.jpg\",\n" +
            "                \"composition\": \"Saxagliptin monohydrate is described chemically as (1S,3S,5S)-2-[(2S)-2-Amino-2-(3-hydroxytricyclo[3.3.1.13,7]dec-1yl)acetyl]-2-azabicyclo[3.1.0]hexane-3-carbonitrile, monohydrate or (1S,3S,5S)-2-[(2S)-2-Amino-2-(3hydroxyadamantan-1-yl)acetyl]-2-azabicyclo[3.1.0]hexane-3-carbonitrile hydrate. The empirical formula is C18H25N3O2•H2O and the molecular weight is 333.43. Saxagliptin monohydrate is a white to light yellow or light brown, non-hygroscopic, crystalline powder. It is sparingly soluble in water at 24°C ± 3°C, slightly soluble in ethyl acetate, and soluble in methanol, ethanol, isopropyl alcohol, acetonitrile, acetone, and polyethylene glycol 400 (PEG 400). Each film-coated tablet of ONGLYZA for oral use contains either 2.79 mg saxagliptin hydrochloride (anhydrous) equivalent to 2.5 mg saxagliptin or 5.58 mg saxagliptin hydrochloride (anhydrous) equivalent to 5 mg saxagliptin and the following inactive ingredients: lactose monohydrate, microcrystalline cellulose, croscarmellose sodium, and magnesium stearate. In addition, the film coating contains the following inactive ingredients: polyvinyl alcohol, polyethylene glycol, titanium dioxide, talc, and iron oxides.\",\n" +
            "                \"dose\": \"The recommended dose of ONGLYZA is 5 mg once daily. When ONGLYZA is used in combination with a sulphonylurea, a lower dose of sulphonylurea may be required to reduce the risk of hypoglycaemia (see section 4.4). The safety and efficacy of saxagliptin as triple oral therapy in combination with metformin and a thiazolidinedione has not been established. ONGLYZA Data Sheet 221019 Copyright 2 Special populations Elderly (≥65 years) No dose adjustment is recommended based solely on age (see sections 4.4, 5.1 and 5.2). Patients with renal impairment Assessment of renal function is recommended prior to initiation of ONGLYZA and periodically thereafter (see sections 4.4 and 5.2). Mild renal Impairment No dose adjustment is recommended for patients with mild renal impairment (eGFR 60-89 mL/min/1.73 m2 (by Modified Diet in Renal Disease [MDRD] eGFR equation). Moderate renal impairment No dosage adjustment is required for patients with eGFR ≥ 45 mL/min/1.73 m2.\",\n" +
            "                \"indication\": \"No information\",\n" +
            "                \"contraindications\": \"Hypersensitivity to the active substance or to any of the excipients, or history of a serious hypersensitivity reaction, including anaphylactic reaction, anaphylactic shock and angioedema, to any dipeptidyl peptidase 4 (DPP4) inhibitor\",\n" +
            "                \"precautions\": \"General ONGLYZA should not be used in patients with type 1 diabetes mellitus or for the treatment of diabetic ketoacidosis. Acute Pancreatitis Use of DPP4 inhibitors has been associated with a risk of developing acute pancreatitis. Patients should be informed of the characteristic symptoms of acute pancreatitis; persistent, severe abdominal pain. If pancreatitis is suspected, ONGLYZA should be discontinued; if acute pancreatitis is confirmed, ONGLYZA should not be restarted. Caution should be exercised in patients with a history of pancreatitis. In post-marketing experience of saxagliptin, there have been spontaneously reported adverse reactions of acute pancreatitis. Renal impairment In patients with eGFR < 45 mL/min/1.73 m2, the dose is 2.5 mg once daily (see section 4.2). Assessment of renal function is recommended prior to initiation of ONGLYZA, and in keeping with routine care, renal assessment.\",\n" +
            "                \"interactions\": \"Clinical data described below suggest that the risk for clinically meaningful interactions with co-administered medicinal products is low. The metabolism of saxagliptin is primarily mediated by cytochrome P450 3A4/5 (CYP3A4/5). Concomitant administration of saxagliptin with the moderate inhibitor of CYP3A4/5 diltiazem, increased the Cmax and AUC of saxagliptin by 63% and 2.1-fold, respectively, and the corresponding values for the active metabolite were decreased by 44 and 34%, respectively. Concomitant administration of saxagliptin with the potent inhibitor of CYP3A4/5 ketoconazole, increased the Cmax and AUC of saxagliptin by 62% and 2.5-fold, respectively, and the corresponding values for the active metabolite were decreased by 95% and 88%, respectively. Concomitant administration of saxagliptin with the potent CYP3A4/5 inducer rifampicin, reduced Cmax and AUC of saxagliptin by 53% and 76%, respectively. The exposure of the active metabolite and the plasma DPP4 activity inhibition over a dose interval were not influenced by rifampicin (see section 4.4). The co-administration of saxagliptin and CYP3A4/5 inducers, other than rifampicin (such as carbamazepine, dexamethasone, phenobarbital and phenytoin) have not been studied and may result in decreased plasma concentration of saxagliptin and increased concentration of its major metabolite. Glycaemic control should be carefully assessed when saxagliptin is used concomitantly with a potent CYP3A4/5 inducer. In in vitro studies, saxagliptin and its major metabolite neither inhibited CYP1A2, 2A6, 2B6, 2C8, 2C9, 2C19, 2D6, 2E1, or 3A4, nor induced CYP1A2, 2B6, 2C9, or 3A4. In studies conducted in healthy subjects, neither the pharmacokinetics of saxagliptin and its major metabolite, were meaningfully altered by metformin, glibenclamide, pioglitazone, digoxin, simvastatin, omeprazole, antacids or famotidine. In addition, saxagliptin did not meaningfully alter the pharmacokinetics of metformin, glibenclamide, pioglitazone, digoxin, simvastatin, the active components of a combined oral contraceptive (ethinyl oestradiol and norgestimate), diltiazem or ketoconazole. The effects of smoking, diet, herbal products, and alcohol use on the pharmacokinetics of saxagliptin have not been specifically studied.\",\n" +
            "                \"side_effects\": \"1).Pancreatitis 2).Heart Failure  3).Hypoglycemia with Concomitant Use of Sulfonylurea or Insulin 4).Hypersensitivity Reactions  5)- Severe and disabling arthralgia 6)- Bullous pemphigoid\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"not reported\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"The use of saxagliptin has not been studied in pregnant women. Studies in animals have shown reproductive toxicity at high doses (see section 5.3). The potential risk for humans is unknown. ONGLYZA should not be used during pregnancy unless clearly necessary.\",\n" +
            "                \"tablets\": [    \n" +
            "                  {\n" +
            "                  \"id\": 1,\n" +
            "                  \"name\": \"30 caps\",\n" +
            "                  \"description\": \"5mg\",\n" +
            "                  \"cost\":\"200 LE\"\n" +
            "                  },\n" +
            "                   {\n" +
            "                  \"id\": 2,\n" +
            "                  \"name\": \"30 caps\",\n" +
            "                  \"description\": \"2.5mg\",\n" +
            "                  \"cost\":\"200 LE\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            },\n" +
            "          {\n" +
            "              \"category\":2,\n" +
            "                \"id\": 26,\n" +
            "                \"name\": \"Harvoni\",\n" +
            "                \"rate\": \"5\",\n" +
            "                \"image\": \"https://tse2.mm.bing.net/th?id=OIP.TvhvfT6o5mKvM-bIFxk5owHaHa&pid=Api&P=0&w=300&h=300\",\n" +
            "                \"composition\": \"sofosbuvir 400mg\",\n" +
            "                \"dose\": \"he recommended dosage of HARVONI in adults with genotype 1, 4, 5, or 6 HCV is one tablet (90 mg ledipasvir and 400 mg sofosbuvir) taken orally once daily with or without food. The daily dosage of ribavirin is weight-based (1000 mg for patients <75 kg and 1200 mg for those ≥75 kg) administered orally in two divided doses with food. In patients with decompensated cirrhosis, the starting dosage of ribavirin is 600 mg and can be titrated up to 1000 mg for patients <75 kg and 1200 mg for those ≥75 kg in two divided doses with food. If the starting dosage of ribavirin is not well tolerated, the dosage should be reduced as clinically indicated based on hemoglobin levels.\",\n" +
            "                \"indication\": \"No information\",\n" +
            "                \"contraindications\": \"No information\",\n" +
            "                \"precautions\": \"Not reported\",\n" +
            "                \"interactions\": \"Advil (ibuprofen), Aleve (naproxen), amlodipine, amoxicillin, Benadryl (diphenhydramine), clonazepam, furosemide, gabapentin, hydrochlorothiazide, ibuprofen, Klonopin (clonazepam), levothyroxine\",\n" +
            "                \"side_effects\": \"right-sided upper stomach pain; vomiting, loss of appetite; or jaundice (yellowing of the skin or eyes), and not feeling well. very slow heartbeats, chest pain, shortness of breath; confusion, memory problems; or weakness, extreme tiredness, light-headed feeling (like you might pass out\",\n" +
            "                \"overdose\": \"not reported\",\n" +
            "                \"pharmacology\": \"not reported\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [    \n" +
            "                  {\n" +
            "                  \"id\": 1,\n" +
            "                  \"name\": \"30 caps\",\n" +
            "                  \"description\": \"400mg\",\n" +
            "                  \"cost\":\"5500 LE\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            },\n" +
            "                {\n" +
            "              \"category\":2,\n" +
            "                \"id\": 27,\n" +
            "                \"name\": \"Ribavirin\",\n" +
            "                \"rate\": \"3.5\",\n" +
            "                \"image\": \"https://tse3.mm.bing.net/th?id=OIP.abFbyemVvBGuI1qyIVT2DwHaHa&pid=Api&P=0&w=300&h=300\",\n" +
            "                \"composition\": \"200mg ribavirin\",\n" +
            "                \"dose\": \"body weight <75kg 400 mg in the morning, >75mg 600mg twic daily\",\n" +
            "                \"indication\": \"No information\",\n" +
            "                \"contraindications\": \"No information\",\n" +
            "                \"precautions\": \"Before taking ribavirin, tell your doctor or pharmacist if you are allergic to it; or if you have any other allergies. This product may contain inactive ingredients, which can cause allergic reactions or other problems. Talk to your pharmacist for more details. Before using this medication, tell your doctor or pharmacist your medical history, especially of: blood disorders (e.g., sickle cell anemia, low hemoglobin, thalassemia), kidney disease, other liver problems (e.g., autoimmune hepatitis), heart disease, high blood pressure, breathing problems, pancreas problems (e.g., pancreatitis), diabetes\",\n" +
            "                \"interactions\": \"Drug interactions may change how your medications work or increase your risk for serious side effects. This document does not contain all possible drug interactions. Keep a list of all the products you use (including prescription/nonprescription drugs and herbal products) and share it with your doctor and pharmacist. Do not start, stop, or change the dosage of any medicines without your doctor's approval.\",\n" +
            "                \"side_effects\": \"Nausea, diarrhea, stomach upset, headache, dizziness, blurred vision, trouble sleeping, cough, low appetite, weight loss or gain, dry skin, or changes in taste/hearing may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\",\n" +
            "                \"overdose\": \"If someone has overdosed and has serious symptoms such as passing out or trouble breathing, call 911. Otherwise, call a poison control center right away. US residents can call their local poison control center at 1-800-222-1222. Canada residents can call a provincial poison control center.\",\n" +
            "                \"pharmacology\": \"not reported\",\n" +
            "                \"packaging\": \"not reported\",\n" +
            "                \"pregnancy\": \"not reported\",\n" +
            "                \"tablets\": [    \n" +
            "                  {\n" +
            "                  \"id\": 1,\n" +
            "                  \"name\": \"1 caps\",\n" +
            "                  \"description\": \"400mg\",\n" +
            "                  \"cost\":\"50 LE\"\n" +
            "                  }\n" +
            "                ]\n" +
            "            }\n" +
            "            ]\n" +
            "    }\n" +
            "}";

//    public String getNormalDrugs() {
//        return "json here";
//    }


    public String getNormalDrugs() {
        return drug1 + drug2 + drug3+ drug4;
    }

}
