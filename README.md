# DNA Analyses

Analysis to detect if is Human DNA or Simian DNA.

## Features

#### Register new DNAs
**api link:** <a hreg="https://dna-simios.herokuapp.com/simian">https://dna-simios.herokuapp.com/simian</a>

**request example:**
```
POST → /simian
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
```
**response:**
<p>Case is simian: HTTP 200-OK</p>
<p>Case is human: HTTP 403-FORBIDDEN</p>

#### DNA stats
**api link:** <a hreg="https://dna-simios.herokuapp.com/stats">https://dna-simios.herokuapp.com/stats</a>

**request example:**
```
GET → /stats
```
**response example:**
```
{"count_mutant_dna": 50, "count_human_dna": 200: "ratio": 0.25}
```
